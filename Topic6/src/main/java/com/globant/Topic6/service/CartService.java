package com.globant.Topic6.service;

import com.globant.Topic6.entity.Cart;
import com.globant.Topic6.entity.CartItem;
import com.globant.Topic6.entity.Product;
import com.globant.Topic6.entity.Purchase;
import com.globant.Topic6.entity.User;

public interface CartService {

	public Cart createCart(Cart cart);

	public Cart showCart(String username);

	public void updateCart(Cart cart);

	public void emptyCart(Cart cart);

	public void addItemToCart(Product product, int quantity, Cart cart);

	public void removeItemFromCart(Product product, Cart cart);

	public void updateQuantity(Product product, int quantity, Cart cart);

	public CartItem findProductInCart(Cart cart, Product product);

	public Purchase checkout(Cart cart);

	public Cart findByUser(User user);

	public void deleteCart(Cart cart);

	public void saveCart(Cart cart);

	public void deletePurchase(Purchase purchase);

}
