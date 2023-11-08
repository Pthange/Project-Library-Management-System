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

import com.library.mgmt.system.dto.AuthorDTO;
import com.library.mgmt.system.entity.Author;
import com.library.mgmt.system.exception.AuthorNotFoundException;
import com.library.mgmt.system.service.AuthorService;
import com.library.mgmt.system.util.Converter;

@RestController
@RequestMapping("/api")    // API endpoint
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private Converter converter;

    // API endpoint to create a new Author
    @PostMapping("/createAuthor")
    ResponseEntity<AuthorDTO> createAuthor(@Valid @RequestBody AuthorDTO authorDTO) throws AuthorNotFoundException {
        final Author author = converter.convertToAuthorEntity(authorDTO);
        return new ResponseEntity<AuthorDTO>(authorService.createAuthor(author), HttpStatus.CREATED);
    }

    // API endpoint to retrieve all Authors
    @GetMapping("/getAllAuthors")
    List<AuthorDTO> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    // API endpoint to retrieve an Author by ID
    @GetMapping("/getAuthorById/{id}")
    AuthorDTO getAuthorById(@PathVariable("id") int id) throws AuthorNotFoundException {
        return authorService.getAuthorById(id);
    }

    // API endpoint to retrieve an Author by name
    @GetMapping("/getAuthorByName/{name}")
    AuthorDTO getAuthorByName(@PathVariable("name") String name) throws AuthorNotFoundException {
        return authorService.getAuthorByName(name);
    }

    // API endpoint to update an Author by ID
    @PutMapping("/updateAuthor/{id}")
    AuthorDTO updateAuthor(@Valid @PathVariable int id, @RequestBody AuthorDTO authorDTO) throws AuthorNotFoundException {
        final Author author = converter.convertToAuthorEntity(authorDTO);
        return authorService.updateAuthor(id, author);
    }

    // API endpoint to delete an Author by ID
    @DeleteMapping("/deleteAuthor/{id}")
    String deleteAuthor(@PathVariable int id) {
        return authorService.deleteAuthor(id);
    }
}
