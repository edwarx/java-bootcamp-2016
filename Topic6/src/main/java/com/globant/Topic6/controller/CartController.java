package com.globant.Topic6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.globant.Topic6.entity.Cart;
import com.globant.Topic6.entity.CartItem;
import com.globant.Topic6.entity.Product;
import com.globant.Topic6.entity.Purchase;
import com.globant.Topic6.service.CartService;
import com.globant.Topic6.service.ProductService;
import com.globant.Topic6.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/cart")
@ComponentScan("com.globant.Topic6.service")
@Api(value = "Cart", description = "All operations related to a cart")
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public Cart showCart(@RequestParam(value = "username", required = false, defaultValue = "") String username) {
		return cartService.showCart(username);

	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void emptyCart(@RequestParam(value = "username", required = true) String username) {
		cartService.emptyCart(cartService.findByUser(userService.findByUsername(username)));
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateCart(@RequestBody Cart cart) {
		cartService.updateCart(cart);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Cart createCart(@RequestBody Cart cart) {
		return cartService.createCart(cart);
	}

	@RequestMapping(value = "/cartItem", method = RequestMethod.POST)
	public void addItemToCart(@RequestParam(value = "productId", required = true) int productId,
			@RequestParam(value = "quantity", required = true) int quantity, @RequestBody Cart cart) {
		cartService.addItemToCart(productService.findById(productId), quantity, cart);
	}

	@RequestMapping(value = "/cartItem", method = RequestMethod.DELETE)
	public void removeItemFromCart(@RequestParam(value = "productId", required = true) int productId, @RequestBody Cart cart) {
		cartService.removeItemFromCart(productService.findById(productId), cart);
	}

	public CartItem findProductInCart(Cart cart, Product product) {

		return cartService.findProductInCart(cart, product);
	}

	@RequestMapping(value = "/cartItem", method = RequestMethod.PUT)
	public void updateQuantity(@RequestParam(value = "productId", required = true) int productId,
			@RequestParam(value = "quantity", required = true) int quantity, @RequestBody Cart cart) {
		cartService.updateQuantity(productService.findById(productId), quantity, cart);
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public Purchase checkout(@RequestBody Cart cart) {
		return cartService.checkout(cart);
	}

}
