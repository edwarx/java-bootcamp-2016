package com.globant.Topic6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.Topic6.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

	public List<CartItem> findById(int cart_id);
}
