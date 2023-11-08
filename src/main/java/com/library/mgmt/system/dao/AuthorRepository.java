package com.library.mgmt.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.mgmt.system.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer>{
	// Finds an Author by name
	public Author findByauthorName(String name);

	

}
