package com.globant.Topic6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.Topic6.entity.Cart;
import com.globant.Topic6.entity.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	public Cart findByUser(User user);
}
