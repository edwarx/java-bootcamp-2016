package com.globant.FinalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.FinalProject.entity.Product;
import com.globant.FinalProject.service.CategoryService;
import com.globant.FinalProject.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Component
@RequestMapping("/product")
@ComponentScan("com.globant.FinalProject.service")
@Api(value = "Product", description = "All operations related to products")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

	@ApiOperation(value = "List of products using params", notes = "Given a category id, lists all the products that belong to that category.\n Given a product name, lists all the products with that name. If not given any params, lists all the products.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "categoryId", required = false, dataType = "int", defaultValue = "-1", paramType = "query"),
			@ApiImplicitParam(name = "productName", required = false, dataType = "String", defaultValue = "", paramType = "query") })
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> listProducts(@RequestParam(value = "categoryId", required = false, defaultValue = "-1") int categoryId,
			@RequestParam(value = "productName", required = false, defaultValue = "") String productName) {
		if (categoryId == -1 && productName.compareTo("") == 0) {
			return productService.listAllProducts();
		}
		if (categoryId != -1) {
			return productService.findByCategory(categoryService.findById(categoryId));
		}
		return productService.findByName(productName);
	}

	@ApiOperation(value = "Retrieve a product using its id")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product findById(@PathVariable int id) {
		return productService.findById(id);
	}

	@ApiOperation(value = "Delete a product using its id")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(productService.findById(id));
	}

	@ApiOperation(value = "Update a product using its id")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateProduct(@PathVariable int id, @RequestBody Product product) {
		productService.updateProduct(product);
	}

	@ApiOperation(value = "Add a new product to the system")
	@RequestMapping(method = RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

}
