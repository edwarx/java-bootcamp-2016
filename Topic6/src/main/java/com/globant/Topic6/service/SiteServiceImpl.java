package com.globant.Topic6.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globant.Topic6.Site;
import com.globant.Topic6.entity.Cart;
import com.globant.Topic6.entity.User;

@Component
public class SiteServiceImpl implements SiteService {

	@Autowired
	UserService userService;
	@Autowired
	CartService cartService;

	/**
	 * Logins a user into the system, if there was a cart before the login,
	 * associates that cart to the user. If the user had a previous cart, the
	 * method loads it and discards the previous cart.
	 */
	@Override
	public boolean login(User user) {
		User temp = userService.findByUsername(user.getUsername());
		if (temp.getPassword().compareTo(user.getPassword()) == 0) {
			Site.getInstance().getLoggedUsers().add(temp);
			if (cartService.findByUser(temp) == null) {
				Cart cart = cartService.findByUser(null);
				if (cart == null) {
					cart = new Cart();
				}
				cart.setUser(temp);
				cartService.saveCart(cart);
			} else {
				Cart cart = cartService.findByUser(null);
				cartService.deleteCart(cart);
			}
			return true;
		}
		return false;

	}

	@Override
	public boolean logout(User user) {
		Iterator<User> it = Site.getInstance().getLoggedUsers().iterator();
		while (it.hasNext()) {
			User temp = it.next();
			if (temp.equals(user)) {
				Site.getInstance().getLoggedUsers().remove(temp);
				return true;
			}
		}
		return false;
	}

}
