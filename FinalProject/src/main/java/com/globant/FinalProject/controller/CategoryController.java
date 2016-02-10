package com.globant.FinalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.globant.FinalProject.entity.Category;
import com.globant.FinalProject.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Configuration
@RequestMapping("/category")
@ComponentScan("com.globant.FinalProject.service")
@Api(value = "Category", description = "All operations related to product's categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@ApiOperation(value = "List of all categories")
	@RequestMapping(method = RequestMethod.GET)
	public List<Category> listAllCategories() {
		return categoryService.listAllCategories();
	}

	@ApiOperation(value = "Retrieve a category using its id")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path") })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Category findById(@PathVariable(value = "id") int categoryId) {
		return categoryService.findById(categoryId);
	}

	@ApiOperation(value = "Delete a category using its id")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCategory(@PathVariable(value = "id") int categoryId) {
		categoryService.deleteCategory(categoryService.findById(categoryId));
	}

	@ApiOperation(value = "Update a category using its id")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", required = true, dataType = "int", paramType = "path") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateCategory(@PathVariable(value = "id") int categoryId, @RequestBody Category category) {
		categoryService.updateCategory(category);
	}

	@ApiOperation(value = "Add a new category to the system")
	@RequestMapping(method = RequestMethod.POST)
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}
}
