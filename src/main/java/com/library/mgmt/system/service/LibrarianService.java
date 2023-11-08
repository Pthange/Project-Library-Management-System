package com.library.mgmt.system.service;

import java.util.List;

import com.library.mgmt.system.dto.LibrarianDTO;
import com.library.mgmt.system.entity.Librarian;

// Service interface for managing Librarian entity
public interface LibrarianService 
{
    // Create a new Librarian
    LibrarianDTO createLibrarian(Librarian librarian);

    // Retrieve all Librarians
    List<LibrarianDTO> getAllLibrarians();

    // Retrieve a Librarian by ID
    LibrarianDTO getLibrarianById(int id);

    // Update a Librarian by ID
    LibrarianDTO updateLibrarian(int id, Librarian librarian);

    // Delete a Librarian by ID
    String deleteLibrarian(int id);
}
