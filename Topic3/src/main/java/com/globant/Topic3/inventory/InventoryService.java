package com.globant.Topic3.inventory;

/**
 * Interface that defines what an Inventory must do.
 * @author Eduardo Salgueiro
 *
 */
public interface InventoryService {
	public void createProduct(Product p);

	public void updateProduct(Product p);

	public void removeProduct(Product p);

	public Product findProduct(Product p);

	public void createCategory(Category c);

	public void updateCategory(Category c);

	public void removeCategory(Category c);

	public Category findCategory(Category c);

}
