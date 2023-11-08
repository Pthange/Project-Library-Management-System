
package com.library.mgmt.system.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.library.mgmt.system.dao.StudentRepository;
import com.library.mgmt.system.entity.Student;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    // ... (Other test methods here)

    @Test
    public void testCreateStudent() {
        // Create and save a student
        Student student = new Student();

        student.setStudName("John Doe");
        student.setStudEmail("john@example.com");
        student.setUserName("john123");
        student.setPassword("7896pwd");

        Student savedStudent = studentRepository.save(student);
        assertNotNull(savedStudent.getId());
    }

    @Test
    public void testGetAllStudents() {
        // Clear the database to ensure a clean state
        studentRepository.deleteAll();

        // Create and save multiple student entities
        Student student1 = new Student(1, "John Doe", "john@example.com", "john123", "securepwd", "12-08-2001","male","Pune", "IT", "8864764921", null, null, null);
        Student student2 = new Student(2, "Alice Smith", "alice@example.com", "alice99", "password123", "18-08-1987", "male", "Delhi","MBBS", "7896541254", null,  null, null);
        
        studentRepository.save(student1);
        studentRepository.save(student2);

        // Retrieve all students from the database
        List<Student> allStudents = studentRepository.findAll();

        // Assert that the list is not empty and contains the expected number of students
        assertNotNull(allStudents);
        assertEquals(2, allStudents.size());
    }

    @Test
    public void testGetStudentById() {
        // Create and save a student
        Student student = new Student();
        student.setUserName("alice99");
        student.setPassword("pass8123");
        student.setStudEmail("alice@example.com");

        student = studentRepository.save(student);

        // Retrieve the student by ID
        Student retrievedStudent = studentRepository.findById(student.getId()).orElse(null);

        // Assert that the retrieved student is not null and has the correct ID
        assertNotNull(retrievedStudent);
        assertEquals(student.getId(), retrievedStudent.getId());
        assertEquals("alice99", retrievedStudent.getUserName());
        assertEquals("pass8123", retrievedStudent.getPassword());
        assertEquals("alice@example.com", retrievedStudent.getStudEmail());
    }

    @Test
    public void testUpdateStudentById() {
        // Create and save a student
        Student student = new Student();
        student.setUserName("john123");       
        student.setStudName("John Doe");

        student = studentRepository.save(student);

        // Update the student's details
        int studentId = student.getId();
        Student updatedStudent = studentRepository.findById(studentId).orElse(null);
        assertNotNull(updatedStudent);

        // Modify the student's attributes
        updatedStudent.setUserName("Ram123"); // Update username        
        updatedStudent.setStudName("Ram Dongare"); // Update name

        // Save the updated student
        updatedStudent = studentRepository.save(updatedStudent);

        // Retrieve the updated student from the database
        Student retrievedStudent = studentRepository.findById(studentId).orElse(null);
        assertNotNull(retrievedStudent);

        // Assert that the attributes have been updated
        assertEquals("Ram123", retrievedStudent.getUserName());
        assertEquals("Ram Dongare", retrievedStudent.getStudName());
    }

    @Test
    public void testDeleteStudentById() {
        // Create and save a student
        Student student = new Student();
        student.setStudName("bobby");
        student.setStudEmail("bob@example.com");

        student = studentRepository.save(student);

        // Get the ID of the student to be deleted
        int studentId = student.getId();

        // Delete the student by ID
        studentRepository.deleteById(studentId);

        // Try to retrieve the deleted student by ID, and it should be null
        Student deletedStudent = studentRepository.findById(studentId).orElse(null);
        assertNull(deletedStudent);
    }
}
