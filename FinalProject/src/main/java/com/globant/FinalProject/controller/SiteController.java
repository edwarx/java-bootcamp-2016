package com.globant.FinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.FinalProject.entity.User;
import com.globant.FinalProject.service.SiteService;
import com.globant.FinalProject.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Component
@ComponentScan("com.globant.FinalProject.service")
@Api(value = "Site", description = "Login and logout operations")
public class SiteController {
	@Autowired
	SiteService siteService;
	@Autowired
	UserService userService;

	@ApiOperation(value = "Login operation")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody User user) {
		if (siteService.login(user)) {
			return "Login successful";
		}
		return "Bad credentials";
	}

	@ApiOperation(value = "Logout operation")
	@ApiImplicitParams({ @ApiImplicitParam(name = "username", required = true, dataType = "String", paramType = "query") })
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
