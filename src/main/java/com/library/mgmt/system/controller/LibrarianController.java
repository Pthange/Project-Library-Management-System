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

import com.library.mgmt.system.dto.LibrarianDTO;
import com.library.mgmt.system.entity.Librarian;
import com.library.mgmt.system.exception.LibrarianNotFoundException;
import com.library.mgmt.system.service.LibrarianService;
import com.library.mgmt.system.util.Converter;

@RestController
@RequestMapping("/api")
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;

    @Autowired
    private Converter converter;

    // Create a new Librarian
    @PostMapping("/createLibrarian")
    ResponseEntity<LibrarianDTO> createLibrarian(@Valid @RequestBody LibrarianDTO librarianDTO) throws LibrarianNotFoundException {
        final Librarian librarian = converter.convertToLibrarianEntity(librarianDTO);
        return new ResponseEntity<LibrarianDTO>(librarianService.createLibrarian(librarian), HttpStatus.CREATED);
    }

    // Get a list of all Librarians
    @GetMapping("/getAllLibrarians")
    List<LibrarianDTO> getAllLibrarians() {
        return librarianService.getAllLibrarians();
    }

    // Get a specific Librarian by ID
    @GetMapping("/getLibrarianById/{id}")
    LibrarianDTO getLibrarianById(@PathVariable("id") int id) throws LibrarianNotFoundException {
        return librarianService.getLibrarianById(id);
    }

    // Update a Librarian's information
    @PutMapping("/updateLibrarian/{id}")
    LibrarianDTO updateLibrarian(@Valid @PathVariable int id, @RequestBody LibrarianDTO librarianDTO) throws LibrarianNotFoundException {
        final Librarian librarian = converter.convertToLibrarianEntity(librarianDTO);
        return librarianService.updateLibrarian(id, librarian);
    }

    // Delete a Librarian by ID
    @DeleteMapping("/deleteLibrarian/{id}")
    String deleteLibrarian(@PathVariable int id) {
        return librarianService.deleteLibrarian(id);
    }
}

