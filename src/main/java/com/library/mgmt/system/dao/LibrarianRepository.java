package com.library.mgmt.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.mgmt.system.entity.Librarian;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian,Integer>{
	// Finds an librarian by ID
	public Librarian findByid(int id);
}
