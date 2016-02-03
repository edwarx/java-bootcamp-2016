package com.globant.Topic6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.Topic6.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public List<Category> findById(int id);
}
