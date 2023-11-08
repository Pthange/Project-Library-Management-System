package com.library.mgmt.system.service;

import java.util.List;

import com.library.mgmt.system.dto.FacultyDTO;
import com.library.mgmt.system.entity.Faculty;

// Service interface for managing Faculty entity
public interface FacultyService 
{
    // Create a new Faculty
    FacultyDTO createFaculty(Faculty faculty);

    // Retrieve all Faculties
    List<FacultyDTO> getAllFaculties();

    // Retrieve a Faculty by ID
    FacultyDTO getFacultyById(int id);

    // Update a Faculty by ID
    FacultyDTO updateFaculty(int id, Faculty faculty);

    // Delete a Faculty by ID
    String deleteFaculty(int id);
}
