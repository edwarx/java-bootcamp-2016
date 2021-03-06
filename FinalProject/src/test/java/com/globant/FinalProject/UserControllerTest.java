package com.globant.FinalProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.globant.FinalProject.App;
import com.globant.FinalProject.controller.UserController;
import com.globant.FinalProject.entity.Address;
import com.globant.FinalProject.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class UserControllerTest {

	@Autowired
	private UserController userController;
	private User user;

	@Before
	public void loadData() {
		user = new User();
		user.setFirstName("Edward");
		user.setLastName("Salgueiro");
		user.setUsername("Edx2505");
		user.setPassword("lalala");
		user.setAddress(new LinkedList<Address>());
		Address address = new Address();
		address.setStreet("Rafael Nuñez");
		address.setCity("Córdoba");
		address.setCountry("Argentina");
		user.getAddress().add(address);
		userController.addUser(user);
	}

	@After
	public void deleteData() {
		userController.deleteUser(user.getUsername());
	}

	@Test
	public void addAndDeleteUserTest() {
		assertNotNull(userController.findByUsername(user.getUsername()));
	}

	@Test
	public void findByNameTest() {
		List<User> userResultList = userController.findByName(user.getFirstName(), user.getLastName());
		Iterator<User> it = userResultList.iterator();
		while (it.hasNext()) {
			User temp = it.next();
			assertEquals(user.getFirstName(), temp.getFirstName());
			assertEquals(user.getLastName(), temp.getLastName());
		}
	}

	@Test
	public void updateUserTest() {
		user.setPassword("NewPassword");
		userController.updateUser(null, user);
		assertEquals(user.getPassword(), userController.findByUsername(user.getUsername()).getPassword());
	}
}
