package com.globant.FinalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globant.FinalProject.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

}
