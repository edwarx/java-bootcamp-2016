package com.globant.Topic6.service;

import com.globant.Topic6.entity.User;

public interface SiteService {

	public boolean login(User user);

	public boolean logout(User user);

}
