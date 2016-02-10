package com.globant.FinalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.FinalProject.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findById(int id);

	public User findByUsername(String username);

	public List<User> findByFirstNameAndLastName(String firstName, String lastName);
}
