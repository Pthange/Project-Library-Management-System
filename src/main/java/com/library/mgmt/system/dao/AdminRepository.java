package com.library.mgmt.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.mgmt.system.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{
	// Finds an Admin by ID
	public Admin findByid(int id);
}
