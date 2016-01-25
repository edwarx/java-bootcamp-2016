package com.globant.Topic3.site;

import java.util.LinkedList;

import com.globant.Topic3.cart.Cart;
import com.globant.Topic3.inventory.Category;
import com.globant.Topic3.inventory.Product;
import com.globant.Topic3.users.User;

/**
 * Class that simulates a database where all the data from the Shopping Cart is stored.
 * 
 */
public class Site {
	private LinkedList<Product> products;
	private LinkedList<Category> categories;
	private LinkedList<User> users;
	private LinkedList<Cart> carts;
	private static Site instance;

	private Site() {
		products = new LinkedList<Product>();
		categories = new LinkedList<Category>();
		users = new LinkedList<User>();
		setCarts(new LinkedList<Cart>());
	}

	public static Site getInstance() {
		if (instance == null) {
			instance = new Site();
		}
		return instance;
	}

	public LinkedList<Product> getProducts() {
		return products;
	}

	public void setProducts(LinkedList<Product> products) {
		this.products = products;
	}

	public LinkedList<User> getUsers() {
		return users;
	}

	public void setUsers(LinkedList<User> users) {
		this.users = users;
	}

	public LinkedList<Category> getCategories() {
		return categories;
	}

	public void setCategories(LinkedList<Category> categories) {
		this.categories = categories;
	}

	public LinkedList<Cart> getCarts() {
		return carts;
	}

	public void setCarts(LinkedList<Cart> carts) {
		this.carts = carts;
	}

}
