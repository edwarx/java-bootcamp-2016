package com.globant.FinalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.FinalProject.entity.Cart;
import com.globant.FinalProject.entity.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	public Cart findByUser(User user);
}
