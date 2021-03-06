package com.globant.FinalProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.globant.FinalProject.App;
import com.globant.FinalProject.Site;
import com.globant.FinalProject.controller.CartController;
import com.globant.FinalProject.controller.CategoryController;
import com.globant.FinalProject.controller.ProductController;
import com.globant.FinalProject.controller.SiteController;
import com.globant.FinalProject.controller.UserController;
import com.globant.FinalProject.entity.Cart;
import com.globant.FinalProject.entity.CartItem;
import com.globant.FinalProject.entity.Category;
import com.globant.FinalProject.entity.Product;
import com.globant.FinalProject.entity.Purchase;
import com.globant.FinalProject.entity.User;
import com.globant.FinalProject.service.CartService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class CartControllerTest {

	@Autowired
	private CartController cartController;
	@Autowired
	private SiteController siteController;
	@Autowired
	private UserController userController;
	@Autowired
	private CartService cartService;
	@Autowired
	private CategoryController categoryController;
	@Autowired
	private ProductController productController;
	private User user;
	private Cart cart;
	private Product product1;
	private Product product2;
	private Category category;
	private CartItem cartItem;
	private CartItem cartItem2;
	private Purchase purchase;

	@Before
	public void loadData() {
		/**
		 * User creation
		 */

		user = new User();
		user.setFirstName("Shizuo");
		user.setLastName("Heiwajima");
		user.setUsername("Shizuo");
		user.setPassword("Ikebukuro");
		user = userController.addUser(user);
		/**
		 * Login.
		 */
		assertEquals("Login successful", siteController.login(user));
		/**
		 * Cart creation
		 */
		cart = cartService.findByUser(user);
		/**
		 * Category creation
		 */
		category = new Category();
		category.setName("Books");
		category.setName("All kinds of printed material");
		category = categoryController.addCategory(category);
		/**
		 * Products creation
		 */
		product1 = new Product();
		product1.setName("The Bible");
		product1.setDescription("Religious book");
		product1.setPrice(1000);
		product1.setCategory(category);
		product1 = productController.addProduct(product1);

		product2 = new Product();
		product2.setName("Coran");
		product2.setDescription("Another Religious book");
		product2.setPrice(50);
		product2.setCategory(category);
		product2 = productController.addProduct(product2);
		/**
		 * CartItem creation
		 */
		cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setProduct(product1);
		cartItem.setQuantity(60);
		cart.getCartItem().add(cartItem);
		cartItem2 = new CartItem();
		cartItem2.setCart(cart);
		cartItem2.setProduct(product2);
		cartItem2.setQuantity(75);
		cart.getCartItem().add(cartItem2);
		cartController.updateCart(cart);
	}

	@After
	public void deleteData() {
		cartController.emptyCart(user.getUsername());
		cart = cartController.showCart(user.getUsername());
		assertEquals("Logout successful", siteController.logout(user.getUsername()));
		userController.deleteUser(user.getUsername());
		productController.deleteProduct(product1.getId());
		productController.deleteProduct(product2.getId());
		categoryController.deleteCategory(category.getId());

	}

	@Test
	public void createAndDeleteCartWithoutUserLoggedInTest() {
		cart = new Cart();
		cart = cartController.createCart(cart);
		assertNotNull(cart);
		cartService.deleteCart(cartService.findByUser(null));
		cart = cartController.showCart(null);
		assertNull(cart);
	}

	@Test
	public void createAndDeleteCartWithUserLoggedIn() {
		assertFalse(Site.getInstance().getLoggedUsers().isEmpty());
		assertNotNull(cart);
		assertEquals(user.getUsername(), cart.getUser().getUsername());
	}

	@Test
	public void addItemToCartTest() {
		assertEquals(2, cartService.findByUser(user).getCartItem().size());
		assertEquals(cartItem.getProduct().getId(), cartService.findByUser(user).getCartItem().get(0).getProduct().getId());
		assertEquals(cartItem.getQuantity(), cartService.findByUser(user).getCartItem().get(0).getQuantity());
		assertEquals(cartItem2.getProduct().getId(), cartService.findByUser(user).getCartItem().get(1).getProduct().getId());
		assertEquals(cartItem2.getQuantity(), cartService.findByUser(user).getCartItem().get(1).getQuantity());
	}

	@Test
	public void updateQuantityTest() {
		cartController.updateQuantity(product1.getId(), 9000, cartService.findByUser(user));
		assertEquals(cartItem.getProduct().getId(), cartService.findByUser(user).getCartItem().get(0).getProduct().getId());
		assertEquals(9000, cartService.findByUser(user).getCartItem().get(0).getQuantity());
	}

	@Test
	public void removeItemFromCart() {
		cartController.removeItemFromCart(product1.getId(), cart);
		assertNull(cartService.findProductInCart(cart, product1));
		assertNotNull(cartService.findProductInCart(cart, product2));
	}

	@Test
	public void checkoutTest() {
		purchase = cartController.checkout(cart);
		assertNotNull(purchase);
		assertEquals(user.getUsername(), purchase.getUser().getUsername());
		cartService.deletePurchase(purchase);

	}
}
