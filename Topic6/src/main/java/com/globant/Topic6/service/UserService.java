package com.globant.Topic6.service;

import java.util.List;

import com.globant.Topic6.entity.User;

public interface UserService {
	public User addUser(User user);

	public void deleteUser(User user);

	public void updateUser(User user);

	public List<User> listAllUsers();

	public List<User> findByName(String firstName, String lastName);

	public User findByUsername(String username);
}
