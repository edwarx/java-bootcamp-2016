package com.globant.Topic6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globant.Topic6.entity.User;
import com.globant.Topic6.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	CartService cartService;

	@Override
	public User addUser(User user) {
		return userRepository.save(user);

	}

	@Override
	public void deleteUser(User user) {
		cartService.deleteCart(cartService.findByUser(user));
		userRepository.delete(user);

	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);

	}

	@Override
	public List<User> listAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<User> findByName(String firstName, String lastName) {
		return userRepository.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
