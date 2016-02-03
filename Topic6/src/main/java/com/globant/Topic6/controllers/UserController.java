package com.globant.Topic6.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.Topic6.App;
import com.globant.Topic6.entity.User;
import com.globant.Topic6.repository.UserRepository;

import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@ApiOperation(value = "getUserList", nickname = "getUserList")

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = App.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(method = RequestMethod.GET)
	public List<User> listAllUsers() {
		return userRepository.findAll();
	}
	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public User findByUsername(@PathVariable String username) {
		return userRepository.findByUsername(username);
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<User> findByName(@RequestParam(value = "firstName", required = true) String firstName, @RequestParam(value = "lastName", required = true) String lastName) {
		return userRepository.findByFirstNameAndLastName(firstName, lastName);
	}
	@RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("username") String username) {
		userRepository.delete(userRepository.findByUsername(username));
	}
	@RequestMapping(value = "/{username}", method = RequestMethod.PUT)
	public void updateUser(@PathVariable("username") String username, @RequestBody User user) {
		userRepository.save(user);
	}
	@RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
		userRepository.save(user);
	}
}
