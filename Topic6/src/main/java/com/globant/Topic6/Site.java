package com.globant.Topic6;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.globant.Topic6.entity.User;

@Component
public class Site {
	private static List<User> loggedUsers;
	private static Site instance;

	public static Site getInstance() {
		if (instance == null) {
			instance = new Site();
			loggedUsers = new LinkedList<User>();
		}
		return instance;
	}

	public List<User> getLoggedUsers() {
		return loggedUsers;
	}
}
