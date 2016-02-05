package com.globant.Topic6;

import static org.junit.Assert.*;

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

import com.globant.Topic6.controller.UserController;
import com.globant.Topic6.entity.Address;
import com.globant.Topic6.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
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
	public void addAndDeleteUserTest()
	{
		assertNotNull(userController.findByUsername(user.getUsername()));
	}
	@Test
	public void findByNameTest() {

		/**
		 * We look up the user in the database using the firstName and the lastName
		 * There may be several users with the same first and last name.
		 */
		List<User> userResultList = userController.findByName(user.getFirstName(), user.getLastName());
		Iterator<User> it = userResultList.iterator();
		while (it.hasNext())
		{
			User temp = it.next();
			assertEquals(user.getFirstName(), temp.getFirstName());
			assertEquals(user.getLastName(), temp.getLastName());
		}
	}
	@Test
	public void updateUserTest() {
		/**
		 * We change the password...
		 */
		user.setPassword("NewPassword");
		userController.updateUser(null, user);
		assertEquals(user.getPassword(), userController.findByUsername(user.getUsername()).getPassword());
	}
}
