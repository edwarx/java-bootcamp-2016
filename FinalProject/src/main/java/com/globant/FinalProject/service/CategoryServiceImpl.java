package com.globant.FinalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globant.FinalProject.entity.Category;
import com.globant.FinalProject.repository.CategoryRepository;

@Component
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public Category addCategory(Category category) {
		return categoryRepository.save(category);

	}

	public void deleteCategory(Category category) {
		categoryRepository.delete(category);

	}

	public Category findById(int categoryId) {
		return categoryRepository.findById(categoryId);
	}

	public List<Category> listAllCategories() {
		return categoryRepository.findAll();
	}

	public void updateCategory(Category category) {
		categoryRepository.save(category);

	}

}
