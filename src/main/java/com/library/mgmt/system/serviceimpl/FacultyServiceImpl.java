package com.library.mgmt.system.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.mgmt.system.dao.FacultyRepository;
import com.library.mgmt.system.dto.FacultyDTO;
import com.library.mgmt.system.entity.Faculty;
import com.library.mgmt.system.exception.ResourceNotFoundException;
import com.library.mgmt.system.service.FacultyService;
import com.library.mgmt.system.util.Converter;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;
 // Dependency injection for facultyRepository
    
    @Autowired
    private Converter converter;
 // Dependency injection for Converter for conversion purposes

    // Method to create a Faculty
    @Override
    public FacultyDTO createFaculty(Faculty faculty) {
        faculty.setFacusername(faculty.getFacusername());
        faculty.setFacpassword(faculty.getFacpassword());
        Faculty fac = facultyRepository.save(faculty);
     // Save the faculty in the database
        return converter.convertToFacultyDTO(fac);
        // Convert and return  faculty the  as a DTO
    }

    // Method to get all Faculties
    @Override
    public List<FacultyDTO> getAllFaculties() {
        List<Faculty> faculties = facultyRepository.findAll();
     // Fetch all faculties from the database
        List<FacultyDTO> dtoList = new ArrayList<>();
        for (Faculty f : faculties) 
        {
            dtoList.add(converter.convertToFacultyDTO(f));
            // Convert each Faculty to DTO and add to the list
        }
        return dtoList;  // Return a list of Faculty DTOs
    }

    // Method to get a Faculty by ID
    @Override
    public FacultyDTO getFacultyById(int id) {
        Faculty f = facultyRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Faculty", "Id", id));
        return converter.convertToFacultyDTO(f);
     // Convert and return the faculty as a DTO
    }

    // Method to update a Faculty by ID
    @Override
    public FacultyDTO updateFaculty(int id, Faculty faculty) {
        Faculty f = facultyRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Faculty", "Id", id));
        f.setFacEmail(faculty.getFacEmail());
        f.setFacName(faculty.getFacName());

        Faculty fac = facultyRepository.save(f);
        // Save the updated faculty
        return converter.convertToFacultyDTO(fac);
     // Convert and return the faculty as a DTO
    }

    // Method to delete a Faculty by ID
    @Override
    public String deleteFaculty(int id) {
        facultyRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Faculty", "Id", id));
     // Fetch Author by ID to delete
        facultyRepository.deleteById(id);
        // Delete the Author by ID
        return "Faculties got deleted successfully!!";
    }
}
