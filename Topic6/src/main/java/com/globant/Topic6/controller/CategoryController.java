package com.globant.Topic6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.globant.Topic6.entity.Category;
import com.globant.Topic6.service.CategoryService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/category")
@ComponentScan("com.globant.Topic6.service")
@Api(value = "Category", description = "All operations related to product's categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Category> listAllCategories() {
		return categoryService.listAllCategories();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Category findById(@PathVariable(value = "id") int categoryId) {
		return categoryService.findById(categoryId);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCategory(@PathVariable(value = "id") int categoryId) {
		categoryService.deleteCategory(categoryService.findById(categoryId));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateCategory(@PathVariable(value = "id") int categoryId, @RequestBody Category category) {
		categoryService.updateCategory(category);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}
}
