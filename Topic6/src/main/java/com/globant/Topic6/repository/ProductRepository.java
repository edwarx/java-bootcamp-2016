package com.globant.Topic6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.Topic6.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> findByName(String name);
}
