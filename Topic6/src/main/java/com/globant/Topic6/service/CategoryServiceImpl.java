package com.globant.Topic6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globant.Topic6.entity.Category;
import com.globant.Topic6.repository.CategoryRepository;

@Component
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);

	}

	@Override
	public void deleteCategory(Category category) {
		categoryRepository.delete(category);

	}

	@Override
	public Category findById(int categoryId) {
		return categoryRepository.findById(categoryId);
	}

	@Override
	public List<Category> listAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public void updateCategory(Category category) {
		categoryRepository.save(category);

	}

}
