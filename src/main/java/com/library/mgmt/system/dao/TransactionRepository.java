package com.library.mgmt.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.mgmt.system.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer>{
	// Finds an transaction by ID
	public Transaction findByid(int id);
}