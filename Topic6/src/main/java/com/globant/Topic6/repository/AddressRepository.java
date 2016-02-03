package com.globant.Topic6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.Topic6.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	public List<Address> findByUser(String username);
}
