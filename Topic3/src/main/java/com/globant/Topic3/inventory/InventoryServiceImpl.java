package com.globant.Topic3.inventory;

import java.util.Iterator;

import com.globant.Topic3.site.Site;

/**
 * Implementation of the InventoryService interface.
 * This class handles everything related to Products and their Categories.
 * @author Eduardo Salgueiro
 *
 */

public class InventoryServiceImpl implements InventoryService {
	/**
	 * Class variable that retrieves the instance of the Site (database mock).
	 */
	Site s;

	/**
	 * Class constructor.
	 */
	public InventoryServiceImpl() {
		s = Site.getInstance();
	}
/**
 * Adds a Product to the database.
 */
	public void createProduct(Product p) {
		s.getProducts().add(p);

	}
	/**
	 * Updates a Product in the database.
	 */

	public void updateProduct(Product p) {
		if (s.getProducts().contains(p)) {
			s.getProducts().remove(p);
			s.getProducts().add(p);
		} else {
			s.getProducts().add(p);
		}

	}
	/**
	 * Removes a Product from the database.
	 */

	public void removeProduct(Product p) {
		if (s.getProducts().contains(p)) {
			s.getProducts().remove(p);
		}
	}

	/**
	 * Searches for a Product in the database.
	 * @return The Product if its found in the database, null if is not in the database.
	 */
	public Product findProduct(Product p) {
		Iterator<Product> it = s.getProducts().iterator();
		while(it.hasNext()) {
			Product aux = it.next();
			if(aux.equals(p)) {
				return aux; 
			}
		}
		return null;
		}
	/**
	 * Adds a Category to the database.
	 */
	public void createCategory(Category c) {
		s.getCategories().add(c);

	}
	/**
	 * Updates a Category in the database.
	 */

	public void updateCategory (Category c) {
		if (s.getCategories().contains(c)) {
			s.getCategories().remove(c);
			s.getCategories().add(c);
		} else {
			s.getCategories().add(c);
		}

	}
	/**
	 * Removes a Category from the database.
	 */
	public void removeCategory(Category c) {
		if (s.getCategories().contains(c)) {
			s.getCategories().remove(c);
		}

	}
	 /** Searches for a Category in the database.
	 * @return The Category if its found in the database, null if is not in the database.
	 */
	public Category findCategory(Category c) {
		Iterator<Category> it = s.getCategories().iterator();
		while(it.hasNext()) {
			Category aux =  it.next();
			if(aux.equals(c)) {
				return aux; 
			}
		}
		return null;
		}

}
