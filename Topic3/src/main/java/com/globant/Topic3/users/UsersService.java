package com.globant.Topic3.users;

/**
 * Interface that defines what a User service must do.
 * @author Eduardo Salgueiro
 *
 */
public interface UsersService {
	public void createUser(User u);

	public void updateUser(User u);

	public void removeUser(User u);

	public User findUser(User u);

	public boolean login(User u);

	public boolean logout(User u);

}
