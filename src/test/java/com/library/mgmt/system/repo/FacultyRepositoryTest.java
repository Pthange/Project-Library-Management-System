package com.library.mgmt.system.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.library.mgmt.system.dao.FacultyRepository;
import com.library.mgmt.system.entity.Faculty;

@SpringBootTest
public class FacultyRepositoryTest {
    @Autowired
    private FacultyRepository facultyRepository;

    // ... (Other test methods here)

    @Test
    public void testCreateFaculty() {
        // Create and save a faculty
        Faculty faculty = new Faculty();
        faculty.setFacName("John Doe");
        faculty.setFacusername("john4");
        faculty.setFacEmail("john@example.com");
        faculty.setFacGender("Male");
        faculty.setFacpassword("8795");

        Faculty savedFaculty = facultyRepository.save(faculty);
        assertNotNull(savedFaculty.getId());
    }
    @Test
    public void testGetAllFaculty() {
        // Clear the database to ensure a clean state
        facultyRepository.deleteAll();

        // Create and save multiple faculty entities
        Faculty faculty1 = new Faculty(1, "Rahul Patil", "rahul1@example.com", "faculty1", "887", null, "male",  null, null, null, null, null);
        Faculty faculty2 = new Faculty(2, "Pooja Raut", "pooja2@example.com", "faculty2", "5545", null, "female",  null, null, null, null, null);
      
        facultyRepository.save(faculty1);
        facultyRepository.save(faculty2);

        // Retrieve all faculty from the database
        List<Faculty> allFaculty = facultyRepository.findAll();

        // Assert that the list is not empty and contains the expected number of faculty
        assertNotNull(allFaculty);
        assertEquals(2, allFaculty.size());
    }

    @Test
    public void testGetFacultyById() {
        // Create and save a faculty
        Faculty faculty = new Faculty();
        faculty.setFacusername("faculty3");
        faculty.setFacpassword("password3");
        faculty.setFacEmail("faculty5@example.com");

        faculty = facultyRepository.save(faculty);

        // Retrieve the faculty by ID
        Faculty retrievedFaculty = facultyRepository.findById(faculty.getId()).orElse(null);

        // Assert that the retrieved faculty is not null and has the correct ID
        assertNotNull(retrievedFaculty);
        assertEquals(faculty.getId(), retrievedFaculty.getId());
        assertEquals("faculty3", retrievedFaculty.getFacusername());
        assertEquals("password3", retrievedFaculty.getFacpassword());
        assertEquals("faculty5@example.com", retrievedFaculty.getFacEmail());
    }

    @Test
    public void testUpdateFacultyById() {
        // Create and save a faculty
        Faculty faculty = new Faculty();
        faculty.setFacusername("faculty1");
        faculty.setFacpassword("password1");
        faculty.setFacEmail("faculty1@example.com");
        faculty.setFacName("Rahul Patil");

        faculty = facultyRepository.save(faculty);

        // Update the faculty's details
        int facultyId = faculty.getId();
        Faculty updatedFaculty = facultyRepository.findById(facultyId).orElse(null);
        assertNotNull(updatedFaculty);

        // Modify the faculty's attributes
        updatedFaculty.setFacusername("newFaculty1"); // Update username
        updatedFaculty.setFacpassword("newPassword1"); // Update password
        updatedFaculty.setFacEmail("newFaculty1@example.com"); // Update email
        updatedFaculty.setFacName("newFacultyname"); // Update name

        // Save the updated faculty
        updatedFaculty = facultyRepository.save(updatedFaculty);

        // Retrieve the updated faculty from the database
        Faculty retrievedFaculty = facultyRepository.findById(facultyId).orElse(null);
        assertNotNull(retrievedFaculty);

        // Assert that the attributes have been updated
        assertEquals("newFaculty1", retrievedFaculty.getFacusername());
        assertEquals("newPassword1", retrievedFaculty.getFacpassword());
        assertEquals("newFaculty1@example.com", retrievedFaculty.getFacEmail());
        assertEquals("newFacultyname", retrievedFaculty.getFacName());
    }

    @Test
    public void testDeleteFacultyById() {
        // Create and save a faculty
        Faculty faculty = new Faculty();
        faculty.setFacusername("faculty2");
        faculty.setFacpassword("password2");
        faculty.setFacEmail("faculty2@example.com");

        faculty = facultyRepository.save(faculty);

        // Get the ID of the faculty to be deleted
        int facultyId = faculty.getId();

        // Delete the faculty by ID
        facultyRepository.deleteById(facultyId);

        // Try to retrieve the deleted faculty by ID, and it should be null
        Faculty deletedFaculty = facultyRepository.findById(facultyId).orElse(null);
        assertNull(deletedFaculty);
    }

}
