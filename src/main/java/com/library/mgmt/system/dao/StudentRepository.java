package com.library.mgmt.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.mgmt.system.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{
	// Finds an student by ID
	public Student findByid(int id);
	
}
