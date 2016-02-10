package com.globant.FinalProject.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globant.FinalProject.entity.Cart;
import com.globant.FinalProject.entity.CartItem;
import com.globant.FinalProject.entity.Product;
import com.globant.FinalProject.entity.Purchase;
import com.globant.FinalProject.entity.User;
import com.globant.FinalProject.repository.CartRepository;
import com.globant.FinalProject.repository.PurchaseRepository;

@Component
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private PurchaseRepository purchaseRepository;

	public Cart createCart(Cart cart) {
		return cartRepository.save(cart);

	}

	public Cart showCart(String username) {
		return findByUser(userService.findByUsername(username));

	}

	public void updateCart(Cart cart) {
		cartRepository.save(cart);

	}

	public void emptyCart(Cart cart) {
		cartRepository.delete(cart);

	}

	public void addItemToCart(Product product, int quantity, Cart cart) {
		CartItem item = new CartItem();
		item.setProduct(product);
		item.setQuantity(quantity);
		item.setCart(cart);
		cart.getCartItem().add(item);
		updateCart(cart);

	}

	public void removeItemFromCart(Product product, Cart cart) {
		cart.getCartItem().remove(findProductInCart(cart, product));
		updateCart(cart);

	}

	public void updateQuantity(Product product, int quantity, Cart cart) {
		CartItem cartItem = findProductInCart(cart, product);
		cartItem.setQuantity(quantity);
		updateCart(cart);

	}

	public CartItem findProductInCart(Cart cart, Product product) {
		Iterator<CartItem> it = cart.getCartItem().iterator();
		while (it.hasNext()) {
			CartItem item = it.next();
			if (item.getProduct().equals(product)) {
				return item;
			}
		}
		return null;
	}

	/**
	 * Creates an order from the current cart, then empties the cart.
	 */

	public Purchase checkout(Cart cart) {
		double total = 0;
		Iterator<CartItem> it = cart.getCartItem().iterator();
		while (it.hasNext()) {
			CartItem temp = it.next();
			total = total + temp.getProduct().getPrice() * temp.getQuantity();
		}
		cart.setTotal(total);
		updateCart(cart);
		deleteCart(cart);
		Purchase purchase = new Purchase();
		purchase.create(cart);
		return purchaseRepository.save(purchase);

	}

	public Cart findByUser(User user) {
		return cartRepository.findByUser(user);
	}

	public void deleteCart(Cart cart) {
		if (cart != null) {
			cartRepository.delete(cart);
		}

	}

	public void saveCart(Cart cart) {
		cartRepository.save(cart);

	}

	public void deletePurchase(Purchase purchase) {
		purchaseRepository.delete(purchase);

	}

}
