package com.library.mgmt.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.mgmt.system.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
	// Finds an book by title
	public Book findBytitle(String title);
	
	public Book findByid(int  id);

	
}
