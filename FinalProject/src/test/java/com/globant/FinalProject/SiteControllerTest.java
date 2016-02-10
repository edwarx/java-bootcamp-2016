package com.globant.FinalProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.globant.FinalProject.App;
import com.globant.FinalProject.controller.SiteController;
import com.globant.FinalProject.controller.UserController;
import com.globant.FinalProject.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class SiteControllerTest {
	@Autowired
	private SiteController siteController;
	@Autowired
	private UserController userController;
	private User user;

	@Before
	public void loadData() {
		user = new User();
		user.setFirstName("Shizuo");
		user.setLastName("Heiwajima");
		user.setUsername("Shizuo");
		user.setPassword("Ikebukuro");
		userController.addUser(user);
	}

	@After
	public void deleteData() {
		userController.deleteUser(user.getUsername());
	}

	@Test
	public void loginAndLogoutSuccessfulTest() {
		assertEquals("Login successful", siteController.login(user));
		assertEquals("Logout successful", siteController.logout(user.getUsername()));
	}

	@Test
	public void loginUnsuccessfulTest() {
		user.setPassword("123");
		assertNotSame("Login successful", siteController.login(user));

	}

	@Test
	public void logoutWithWrongUserNameTest() {
		assertEquals("Login successful", siteController.login(user));
		user.setUsername("Izaya");
		assertNotSame("Logout successful", siteController.logout(user.getUsername()));
		user.setUsername("Shizuo");
		assertEquals("Logout successful", siteController.logout(user.getUsername()));
	}

	@Test
	public void logoutWhenAlreadyLoggetOutTest() {
		assertEquals("Login successful", siteController.login(user));
		assertEquals("Logout successful", siteController.logout(user.getUsername()));
		assertNotSame("Logout successful", siteController.logout(user.getUsername()));
	}
}
