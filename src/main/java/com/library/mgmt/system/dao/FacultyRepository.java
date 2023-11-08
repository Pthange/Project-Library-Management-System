package com.library.mgmt.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.mgmt.system.entity.Faculty;
@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Integer>{
	// Finds an Faculty by ID
	public Faculty findByid(int id);
}
