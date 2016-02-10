package com.globant.FinalProject.service;

import com.globant.FinalProject.entity.User;

public interface SiteService {

	public boolean login(User user);

	public boolean logout(User user);

}
