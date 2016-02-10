package com.globant.FinalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globant.FinalProject.entity.Category;
import com.globant.FinalProject.entity.Product;
import com.globant.FinalProject.repository.ProductRepository;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product findById(int productId) {
		return productRepository.findById(productId);
	}

	public Product addProduct(Product product) {
		return productRepository.save(product);

	}

	public void deleteProduct(Product product) {
		productRepository.delete(product);

	}

	public List<Product> listAllProducts() {
		return productRepository.findAll();
	}

	public void updateProduct(Product product) {
		productRepository.save(product);

	}

	public List<Product> findByCategory(Category category) {
		return productRepository.findByCategory(category);
	}

	public List<Product> findByName(String productName) {
		return productRepository.findByName(productName);
	}

}
