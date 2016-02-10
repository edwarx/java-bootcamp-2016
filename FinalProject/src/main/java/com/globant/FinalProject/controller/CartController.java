package com.globant.FinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.FinalProject.entity.Cart;
import com.globant.FinalProject.entity.Purchase;
import com.globant.FinalProject.service.CartService;
import com.globant.FinalProject.service.ProductService;
import com.globant.FinalProject.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Configuration
@RequestMapping("/cart")
@ComponentScan("com.globant.FinalProject.service")
@Api(value = "Cart", description = "All operations related to a cart")
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;

	@ApiOperation(value = "Show the cart of a given user")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue = "") })
	@RequestMapping(method = RequestMethod.GET)
	public Cart showCart(@RequestParam(value = "username", required = false, defaultValue = "") String username) {
		return cartService.showCart(username);
	}

	@ApiOperation(value = "Empty the cart of a given user")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "username", value = "User's name", required = true, dataType = "string", paramType = "query") })
	@RequestMapping(method = RequestMethod.DELETE)
	public void emptyCart(@RequestParam(value = "username", required = true) String username) {
		cartService.emptyCart(cartService.findByUser(userService.findByUsername(username)));
	}

	@ApiOperation(value = "Update the current cart")
	@RequestMapping(method = RequestMethod.PUT)
	public void updateCart(@RequestBody Cart cart) {
		cartService.updateCart(cart);
	}

	@ApiOperation(value = "Create a cart")
	@RequestMapping(method = RequestMethod.POST)
	public Cart createCart(@RequestBody Cart cart) {
		return cartService.createCart(cart);
	}

	@ApiOperation(value = "Add an item to the cart")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "productId", value = "Product's id number", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "quantity", value = "Quantity of the product", required = true, dataType = "int", paramType = "query") })
	@RequestMapping(value = "/cartItem", method = RequestMethod.POST)
	public void addItemToCart(@RequestParam(value = "productId", required = true) int productId,
			@RequestParam(value = "quantity", required = true) int quantity, @RequestBody Cart cart) {
		cartService.addItemToCart(productService.findById(productId), quantity, cart);
	}

	@ApiOperation(value = "Remove an item from the cart")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "productId", value = "Product's id number", required = true, dataType = "int", paramType = "query") })
	@RequestMapping(value = "/cartItem", method = RequestMethod.DELETE)
	public void removeItemFromCart(@RequestParam(value = "productId", required = true) int productId, @RequestBody Cart cart) {
		cartService.removeItemFromCart(productService.findById(productId), cart);
	}

	@ApiOperation(value = "Update the quantity of a product in the cart")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "productId", value = "Product's id number", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "quantity", value = "Quantity of the product", required = true, dataType = "int", paramType = "query") })
	@RequestMapping(value = "/cartItem", method = RequestMethod.PUT)
	public void updateQuantity(@RequestParam(value = "productId", required = true) int productId,
			@RequestParam(value = "quantity", required = true) int quantity, @RequestBody Cart cart) {
		cartService.updateQuantity(productService.findById(productId), quantity, cart);
	}

	@ApiOperation(value = "Checkout", notes = "Generate an order with the current cart")
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public Purchase checkout(@RequestBody Cart cart) {
		return cartService.checkout(cart);
	}
}
