package com.library.mgmt.system.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.mgmt.system.dto.FacultyDTO;
import com.library.mgmt.system.entity.Faculty;
import com.library.mgmt.system.exception.FacultyNotFoundException;
import com.library.mgmt.system.service.FacultyService;
import com.library.mgmt.system.util.Converter;

@RestController
@RequestMapping("/api")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private Converter converter;

  //create a faculty
    @PostMapping("/createFaculty")
    ResponseEntity<FacultyDTO> createFaculty(@Valid @RequestBody FacultyDTO facultyDTO) throws FacultyNotFoundException {
        final Faculty faculty = converter.convertToFacultyEntity(facultyDTO);
        return new ResponseEntity<FacultyDTO>(facultyService.createFaculty(faculty), HttpStatus.CREATED);
    }

    // get all faculties
    @GetMapping("/getAllFaculties")
    List<FacultyDTO> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    //get a faculty by its ID
    @GetMapping("/getFacultyById/{id}")
    FacultyDTO getFacultyById(@PathVariable("id") int id) throws FacultyNotFoundException {
        return facultyService.getFacultyById(id);
    }

    // update a faculty
    @PutMapping("/updateFaculty/{id}")
    FacultyDTO updateFaculty(@Valid @PathVariable int id, @RequestBody FacultyDTO facultyDTO) throws FacultyNotFoundException {
        final Faculty faculty = converter.convertToFacultyEntity(facultyDTO);
        return facultyService.updateFaculty(id, faculty);
    }

    //delete a faculty by its ID
    @DeleteMapping("/deleteFaculty/{id}")
    String deleteFaculty(@PathVariable int id) {
        return facultyService.deleteFaculty(id);
    }
}
