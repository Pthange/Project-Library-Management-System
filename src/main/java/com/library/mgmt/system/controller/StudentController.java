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

import com.library.mgmt.system.dto.StudentDTO;
import com.library.mgmt.system.entity.Student;
import com.library.mgmt.system.exception.StudentNotFoundException;
import com.library.mgmt.system.service.StudentService;
import com.library.mgmt.system.util.Converter;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private Converter converter;

    //create a student
    @PostMapping("/createStudent")
    ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO studentDTO) throws StudentNotFoundException {
        final Student student = converter.convertToStudentEntity(studentDTO);
        return new ResponseEntity<StudentDTO>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    //get all students
    @GetMapping("/getAllStudents")
    List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    //get a student by its ID
    @GetMapping("/getStudentById/{sid}")
    StudentDTO getStudentById(@PathVariable("sid") int id) throws StudentNotFoundException {
        return studentService.getStudentById(id);
    }

    //update a student
    @PutMapping("/updateStudent/{id}")
    StudentDTO updateStudent(@Valid @PathVariable int id, @RequestBody StudentDTO studentDTO) throws StudentNotFoundException {
        final Student student = converter.convertToStudentEntity(studentDTO);
        return studentService.updateStudent(id, student);
    }

    //delete a student by its ID
    @DeleteMapping("/deleteStudent/{id}")
    String deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }
}
