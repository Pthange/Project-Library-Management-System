
package com.library.mgmt.system.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.library.mgmt.system.dao.LibrarianRepository;
import com.library.mgmt.system.entity.Librarian;


@SpringBootTest
public class LibrarianRepositoryTest {
    @Autowired
    private LibrarianRepository librarianRepository;
    // ... (Other test methods here)

    @Test
    public void testCreateLibrarian() {
        // Create and save a librarian
        Librarian librarian = new Librarian();

        librarian.setLibName("Rahul Patil");
        librarian.setLibEmail("librahul21@example.com");
        librarian.setLibpassword("lib78");
        librarian.setLibusername("rahul12");

        Librarian savedLibrarian = librarianRepository.save(librarian);
        assertNotNull(savedLibrarian.getId());
    }

    @Test
    public void testGetAllLibrarians() {
        // Clear the database to ensure a clean state
        librarianRepository.deleteAll();

        // Create and save multiple librarian entities
        Librarian librarian1 = new Librarian(1, "Rahul Patil", "librarian1@example.com", "librarian1", "5451", null, "Male",  null, null);
        Librarian librarian2 = new Librarian(2, "Pooja Raut", "poojan2@example.com", "lib12", "5452", null, "Female",  null, null);
        
        librarianRepository.save(librarian1);
        librarianRepository.save(librarian2);

        // Retrieve all librarians from the database
        List<Librarian> allLibrarians = librarianRepository.findAll();

        // Assert that the list is not empty and contains the expected number of librarians
        assertNotNull(allLibrarians);
        assertEquals(2, allLibrarians.size());
    }

    @Test
    public void testGetLibrarianById() {
        // Create and save a librarian
        Librarian librarian = new Librarian();
        librarian.setLibusername("ajay3");
        librarian.setLibpassword("1263");
        librarian.setLibEmail("ajay5@example.com");

        librarian = librarianRepository.save(librarian);

        // Retrieve the librarian by ID
        Librarian retrievedLibrarian = librarianRepository.findById(librarian.getId()).orElse(null);

        // Assert that the retrieved librarian is not null and has the correct ID
        assertNotNull(retrievedLibrarian);
        assertEquals(librarian.getId(), retrievedLibrarian.getId());
        assertEquals("ajay3", retrievedLibrarian.getLibusername());
        assertEquals("1263", retrievedLibrarian.getLibpassword());
        assertEquals("ajay5@example.com", retrievedLibrarian.getLibEmail());
    }

    @Test
    public void testUpdateLibrarianById() {
        // Create and save a librarian
        Librarian librarian = new Librarian();
        librarian.setLibusername("radha1");
        librarian.setLibName("Radha Patil");

        librarian = librarianRepository.save(librarian);

        // Update the librarian's details
        int librarianId = librarian.getId();
        Librarian updatedLibrarian = librarianRepository.findById(librarianId).orElse(null);
        assertNotNull(updatedLibrarian);

        // Modify the librarian's attributes
        updatedLibrarian.setLibusername("newLibrarian1"); // Update username
        updatedLibrarian.setLibpassword("newPassword1"); // Update password
        updatedLibrarian.setLibEmail("newLibrarian1@example.com"); // Update email
        updatedLibrarian.setLibName("newLibrarianname"); // Update name

        // Save the updated librarian
        updatedLibrarian = librarianRepository.save(updatedLibrarian);

        // Retrieve the updated librarian from the database
        Librarian retrievedLibrarian = librarianRepository.findById(librarianId).orElse(null);
        assertNotNull(retrievedLibrarian);

        // Assert that the attributes have been updated
        assertEquals("newLibrarian1", retrievedLibrarian.getLibusername());
        assertEquals("newPassword1", retrievedLibrarian.getLibpassword());
        assertEquals("newLibrarian1@example.com", retrievedLibrarian.getLibEmail());
        assertEquals("newLibrarianname", retrievedLibrarian.getLibName());
    }

    @Test
    public void testDeleteLibrarianById() {
        // Create and save a librarian
        Librarian librarian = new Librarian();
        librarian.setLibName("librarian2");        

        librarian = librarianRepository.save(librarian);

        // Get the ID of the librarian to be deleted
        int librarianId = librarian.getId();

        // Delete the librarian by ID
        librarianRepository.deleteById(librarianId);

        // Try to retrieve the deleted librarian by ID, and it should be null
        Librarian deletedLibrarian = librarianRepository.findById(librarianId).orElse(null);
        assertNull(deletedLibrarian);
    }
}
