package com.library.mgmt.system.service;

import java.util.List;

import com.library.mgmt.system.dto.StudentDTO;
import com.library.mgmt.system.entity.Student;

// Service interface for managing Student entity
public interface StudentService 
{
    // Create a new Student
    StudentDTO createStudent(Student student);

    // Retrieve all Students
    List<StudentDTO> getAllStudents();

    // Retrieve a Student by ID
    StudentDTO getStudentById(int id);

    // Update a Student by ID
    StudentDTO updateStudent(int id, Student student);

    // Delete a Student by ID
    String deleteStudent(int id);
}
