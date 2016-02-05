package com.globant.Topic6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.Topic6.entity.User;
import com.globant.Topic6.service.SiteService;
import com.globant.Topic6.service.UserService;

@RestController
@ComponentScan("com.globant.Topic6.service")
public class SiteController {
	@Autowired
	SiteService siteService;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody User user) {
		if (siteService.login(user)) {
			return "Login successful";
		}
		return "Bad credentials";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(@RequestParam(value = "username", required = true) String username) {
		User user = new User();
		user.setUsername(username);
		if (siteService.logout(user)) {
			return "Logout successful";
		}
		return "User wasn't logged in or doesn't exist";
	}

}
