package com.globant.FinalProject;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.globant.FinalProject.entity.User;

/**
 * Class that keeps in memory the list of logged in users. Implemented using the
 * Singleton design pattern.
 * 
 * @author Eduardo Salgueiro
 *
 */

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
