package com.library.mgmt.system.serviceimpl;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.mgmt.system.dao.AuthorRepository;
import com.library.mgmt.system.dto.AuthorDTO;
import com.library.mgmt.system.entity.Author;
import com.library.mgmt.system.exception.ResourceNotFoundException;
import com.library.mgmt.system.service.AuthorService;
import com.library.mgmt.system.util.Converter;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository; 
    // Dependency injection for accessing the Author data from the database

    @Autowired
    private Converter converter; 
    // Dependency injection for converting Author entities to DTOs

    @Override
    public AuthorDTO createAuthor(Author author) 
    {
        // Create and save an Author entity with specific attributes
        author.setAuthorName(author.getAuthorName());
    	author.setNationality(author.getNationality());
        
        Author authorEntity = authorRepository.save(author); 
        // Save the Author in the database
        return converter.convertToAuthorDTO(authorEntity); 
        // Convert and return the Author as a DTO
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll(); 
        // Fetch all Authors from the database

        List<AuthorDTO> dtoList = new ArrayList<>();
        for (Author author : authors) {
            dtoList.add(converter.convertToAuthorDTO(author)); 
            // Convert each Author to DTO and add to the list
        }

        return dtoList; // Return a list of Author DTOs
    }

    @Override
    public AuthorDTO getAuthorById(int id) {
        Author author = authorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Author", "Id", id)); // Fetch Author by ID
        
        return converter.convertToAuthorDTO(author); 
        // Convert and return the Author as a DTO
    }

    @Override
    public AuthorDTO getAuthorByName(String name) {
        Author author = authorRepository.findByauthorName(name); // Fetch Author by name
        return converter.convertToAuthorDTO(author); // Convert and return the Author as a DTO
    }

    @Override
    public AuthorDTO updateAuthor(int id, Author author) {
        Author authorEntity = authorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Author", "Id", id)); // Fetch Author by ID
        
        author.setAuthorName(author.getAuthorName());
    	author.setNationality(author.getNationality());
        // Update specific attributes for the Author entity
        
        Author updatedAuthor = authorRepository.save(authorEntity); 
        // Save the updated Author
        return converter.convertToAuthorDTO(updatedAuthor); 
        // Convert and return the updated Author as a DTO
    }

    @Override
    public String deleteAuthor(int id) {
        authorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Author", "Id", id)); // Fetch Author by ID to delete
        
        authorRepository.deleteById(id); 
        // Delete the Author by ID
        return "Author deleted successfully!"; 
        // Return success message after deletion
    }
}
