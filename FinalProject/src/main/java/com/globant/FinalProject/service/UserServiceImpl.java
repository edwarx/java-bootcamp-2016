package com.globant.FinalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globant.FinalProject.entity.User;
import com.globant.FinalProject.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CartService cartService;

	public User addUser(User user) {
		return userRepository.save(user);

	}

	public void deleteUser(User user) {
		cartService.deleteCart(cartService.findByUser(user));
		userRepository.delete(user);

	}

	public void updateUser(User user) {
		user.setId(this.findByUsername(user.getUsername()).getId());
		userRepository.save(user);
	}

	public List<User> listAllUsers() {
		return userRepository.findAll();
	}

	public List<User> findByName(String firstName, String lastName) {
		return userRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
