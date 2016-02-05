package com.globant.Topic6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globant.Topic6.entity.Category;
import com.globant.Topic6.entity.Product;
import com.globant.Topic6.repository.ProductRepository;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product findById(int productId) {
		return productRepository.findById(productId);
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);

	}

	@Override
	public void deleteProduct(Product product) {
		productRepository.delete(product);

	}

	@Override
	public List<Product> listAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.save(product);

	}

	@Override
	public List<Product> findByCategory(Category category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public List<Product> findByName(String productName) {
		return productRepository.findByName(productName);
	}

}
