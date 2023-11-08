package com.library.mgmt.system.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.mgmt.system.dao.StudentRepository;
import com.library.mgmt.system.dto.StudentDTO;
import com.library.mgmt.system.entity.Student;
import com.library.mgmt.system.exception.ResourceNotFoundException;
import com.library.mgmt.system.service.StudentService;
import com.library.mgmt.system.util.Converter;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Converter converter;

    // Method to create a Student
    @Override
    public StudentDTO createStudent(Student student) {
        Student stud = studentRepository.save(student);
        return converter.convertToStudentDTO(stud);
    }

    // Method to retrieve all Students
    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        
        // List of type DTO
        List<StudentDTO> dtoList = new ArrayList<>();
        for (Student s : students) {
            dtoList.add(converter.convertToStudentDTO(s));
        }
        
        return dtoList;
    }

    // Method to get a Student by ID
    @Override
    public StudentDTO getStudentById(int id) {
        Student s = studentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student", "Id", id));
        return converter.convertToStudentDTO(s);
    }

    // Method to update a Student by ID
    @Override
    public StudentDTO updateStudent(int id, Student student) {
        Student s = studentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student", "Id", id));
        
        s.setStudEmail(s.getStudEmail());
        s.setStudName(student.getStudName());
        
        Student stud = studentRepository.save(s);
        return converter.convertToStudentDTO(stud);
    }

    // Method to delete a Student by ID
    @Override
    public String deleteStudent(int id) {
        studentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student", "Id", id));

        studentRepository.deleteById(id);
        return "Students got deleted successfully!";
    }
}
