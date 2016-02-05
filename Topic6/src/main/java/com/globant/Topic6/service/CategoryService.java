package com.globant.Topic6.service;

import java.util.List;

import com.globant.Topic6.entity.Category;

public interface CategoryService {
	public Category addCategory(Category category);

	public void deleteCategory(Category category);

	public Category findById(int categoryId);

	public List<Category> listAllCategories();

	public void updateCategory(Category category);

}
