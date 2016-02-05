package com.globant.Topic6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.Topic6.entity.Product;
import com.globant.Topic6.service.CategoryService;
import com.globant.Topic6.service.ProductService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/product")
@ComponentScan("com.globant.Topic6.service")
@Api(value = "Product", description = "All operations related to products")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product findById(@PathVariable int id) {
		return productService.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(productService.findById(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateProduct(@PathVariable int id, @RequestBody Product product) {
		productService.updateProduct(product);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

}
