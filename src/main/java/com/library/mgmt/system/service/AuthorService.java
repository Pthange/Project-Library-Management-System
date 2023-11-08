package com.library.mgmt.system.service;

import java.util.List;
import com.library.mgmt.system.dto.AuthorDTO;
import com.library.mgmt.system.entity.Author;

// Service interface for Author entities
public interface AuthorService {
    // Create an Author
    AuthorDTO createAuthor(Author author);

    // Get all Authors
    List<AuthorDTO> getAllAuthors();

    // Get an Author by ID
    AuthorDTO getAuthorById(int id);

    // Get an Author by Name
    AuthorDTO getAuthorByName(String name);

    // Update an Author by ID
    AuthorDTO updateAuthor(int id, Author author);

    // Delete an Author by ID
    String deleteAuthor(int id);
}
