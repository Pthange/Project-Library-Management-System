
package com.library.mgmt.system.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.library.mgmt.system.dao.AuthorRepository;
import com.library.mgmt.system.entity.Author;


@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;
 // ... (Other test methods here)

    @Test
    public void testCreateAuthor() {
        // Create and save an author
        Author author = new Author();

        author.setAuthorName("John Doe");
        author.setAuthorGender("male");
        author.setBooktitle("American");

        Author savedAuthor = authorRepository.save(author);
        assertNotNull(savedAuthor.getId());
    }

    @Test
    public void testGetAllAuthors() {
        // Clear the database to ensure a clean state
        authorRepository.deleteAll();

        // Create and save multiple author entities
        Author author1 = new Author(1,"John Doe","American","Male", null );
        Author author2 = new Author(2, " Harper Lee","Australian","Male", null);
        Author author3 = new Author(3, "Aarya Bhatt","Indian" ,"Male", null);

        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);

        // Retrieve all authors from the database
        List<Author> allAuthors = authorRepository.findAll();

        // Assert that the list is not empty and contains the expected number of authors
        assertNotNull(allAuthors);
        assertEquals(3, allAuthors.size());
    }
    
    @Test
    public void testGetAuthorById() {
        // Create and save an author
        Author author = new Author();
        author.setAuthorName("Umin");
        author.setAuthorGender("Female");
        author.setBooktitle("Korean");

        author = authorRepository.save(author);

        // Retrieve the author by ID
        Author retrievedAuthor = authorRepository.findById(author.getId()).orElse(null);

        // Assert that the retrieved author is not null and has the correct ID
        assertNotNull(retrievedAuthor);
        assertEquals(author.getId(), retrievedAuthor.getId());
        assertEquals("Umin", retrievedAuthor.getAuthorName());
        assertEquals("Female", retrievedAuthor.getAuthorGender());
        assertEquals("Korean", retrievedAuthor.getBooktitle());
    }

    @Test
    public void testUpdateAuthorById() {
        // Create and save an author
        Author author = new Author();
        author.setAuthorGender("Male");
        author.setAuthorName("R.K.Kale");
  
        author = authorRepository.save(author);

        // Update the author's details
        int authorId = author.getId();
        Author updatedAuthor = authorRepository.findById(authorId).orElse(null);
        assertNotNull(updatedAuthor);

        // Modify the author's attributes
        updatedAuthor.setAuthorName("R.K.Kale"); // Update name
        updatedAuthor.setAuthorGender("Male"); // Update gender

        // Save the updated author
        updatedAuthor = authorRepository.save(updatedAuthor);

        // Retrieve the updated author from the database
        Author retrievedAuthor = authorRepository.findById(authorId).orElse(null);
        assertNotNull(retrievedAuthor);

        // Assert that the attributes have been updated
        assertEquals("R.K.Kale", retrievedAuthor.getAuthorName());
        assertEquals("Male", retrievedAuthor.getAuthorGender());
        
    }

    @Test
    public void testDeleteAuthorById() {
        // Create and save an author
        Author author = new Author();
        author.setAuthorName("jane2");
        

        author = authorRepository.save(author);

        // Get the ID of the author to be deleted
        int authorId = author.getId();

        // Delete the author by ID
        authorRepository.deleteById(authorId);

        // Try to retrieve the deleted author by ID, and it should be null
        Author deletedAuthor = authorRepository.findById(authorId).orElse(null);
        assertNull(deletedAuthor);
    }

    @Test
    public void testGetAuthorByName() {
        // Create and save an author
        Author author = new Author();
        author.setAuthorName("Umin");
        author.setAuthorGender("Female");
        author.setBooktitle("Korean");

        author = authorRepository.save(author);

        // Retrieve the author by ID
        Author retrievedAuthor = authorRepository.findById(author.getId()).orElse(null);

        // Assert that the retrieved author is not null and has the correct ID
        assertNotNull(retrievedAuthor);
        assertEquals(author.getId(), retrievedAuthor.getId());
        assertEquals("Umin", retrievedAuthor.getAuthorName());
        assertEquals("Female", retrievedAuthor.getAuthorGender());
        assertEquals("Korean", retrievedAuthor.getBooktitle());
    }


}
