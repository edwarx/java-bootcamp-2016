package com.globant.Topic6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.Topic6.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	public List<Cart> findByUser(String username);
}
