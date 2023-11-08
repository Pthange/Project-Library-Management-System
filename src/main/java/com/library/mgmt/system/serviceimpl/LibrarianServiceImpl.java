package com.library.mgmt.system.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.mgmt.system.dao.LibrarianRepository;
import com.library.mgmt.system.dto.LibrarianDTO;
import com.library.mgmt.system.entity.Librarian;
import com.library.mgmt.system.exception.ResourceNotFoundException;
import com.library.mgmt.system.service.LibrarianService;
import com.library.mgmt.system.util.Converter;

@Service
public class LibrarianServiceImpl implements LibrarianService {

    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private Converter converter;

    // Method to create a Librarian
    @Override
    public LibrarianDTO createLibrarian(Librarian librarian) {
        librarian.setLibusername(librarian.getLibusername());
        Librarian librarianEntity = librarianRepository.save(librarian);
        return converter.convertToLibrarianDTO(librarianEntity);
    }

    // Method to retrieve all Librarians
    @Override
    public List<LibrarianDTO> getAllLibrarians() {
        List<Librarian> librarians = librarianRepository.findAll();

        List<LibrarianDTO> dtoList = new ArrayList<>();
        for (Librarian librarian : librarians) {
            dtoList.add(converter.convertToLibrarianDTO(librarian));
        }

        return dtoList;
    }

    // Method to get a Librarian by ID
    @Override
    public LibrarianDTO getLibrarianById(int id) {
        Librarian librarian = librarianRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Librarian", "Id", id));
        return converter.convertToLibrarianDTO(librarian);
    }

    // Method to update a Librarian by ID
    @Override
    public LibrarianDTO updateLibrarian(int id, Librarian librarian) {
        Librarian librarianEntity = librarianRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Librarian", "Id", id));

        librarian.setLibName(librarian.getLibName());
        Librarian updatedLibrarian = librarianRepository.save(librarianEntity);
        return converter.convertToLibrarianDTO(updatedLibrarian);
    }

    // Method to delete a Librarian by ID
    @Override
    public String deleteLibrarian(int id) {
        librarianRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Librarian", "Id", id));

        librarianRepository.deleteById(id);
        return "Librarian deleted successfully!";
    }
}
