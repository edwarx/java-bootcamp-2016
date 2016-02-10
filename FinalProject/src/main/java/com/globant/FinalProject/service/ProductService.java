package com.globant.FinalProject.service;

import java.util.List;

import com.globant.FinalProject.entity.Category;
import com.globant.FinalProject.entity.Product;

public interface ProductService {

	public Product findById(int productId);

	public Product addProduct(Product product);

	public void deleteProduct(Product product);

	public List<Product> listAllProducts();

	public void updateProduct(Product product);

	public List<Product> findByCategory(Category category);

	public List<Product> findByName(String productName);
}
