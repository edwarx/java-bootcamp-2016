package com.globant.Topic6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.Topic6.App;
import com.globant.Topic6.entity.User;
import com.globant.Topic6.service.UserService;

import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/user")
@ComponentScan("com.globant.Topic6.service")
@Api(value = "User", description = "All operations related to users")
public class UserController {

	@Autowired
	private UserService userService;
	@ApiOperation(value = "List of all users")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> listAllUsers() {
		return userService.listAllUsers();
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User findByUsername(@PathVariable("username") String username) {
		return userService.findByUsername(username);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findByName(@RequestParam(value = "firstName", required = true) String firstName,
			@RequestParam(value = "lastName", required = true) String lastName) {
		return userService.findByName(firstName, lastName);
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteUser(@PathVariable("username") String username) {
		userService.deleteUser(userService.findByUsername(username));
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(@PathVariable("username") String username, @RequestBody User user) {
		userService.updateUser(user);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = App.class),
			@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
}
