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
import com.library.mgmt.system.dto.AdminDTO;
import com.library.mgmt.system.entity.Admin;
import com.library.mgmt.system.exception.AdminNotFoundException;
import com.library.mgmt.system.service.AdminService;
import com.library.mgmt.system.util.Converter;

@RestController
@RequestMapping("/api")

//Class responsible for handling API requests related to Admin entities.
public class AdminController 
{
	// Autowiring AdminService and Converter dependencies to facilitate access to their functionalities within the AdminController.
	
	// AdminService is used to manage Admin-related business logic.
    @Autowired
    private AdminService adminService;

    // Converter is utilized for converting between AdminDTO and Admin entity objects.
    @Autowired
    private Converter converter;

    // Create a new Admin
    @PostMapping("/createAdmin")
    ResponseEntity<AdminDTO> createAdmin(@Valid @RequestBody AdminDTO adminDTO) throws AdminNotFoundException {
        final Admin admin = converter.convertToAdminEntity(adminDTO);
        return new ResponseEntity<AdminDTO>(adminService.createAdmin(admin), HttpStatus.CREATED);
    }

    // Get all Admins
    @GetMapping("/getAllAdmins")
    List<AdminDTO> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    // Get an Admin by ID
    @GetMapping("/getAdminById/{id}")
    AdminDTO getAdminById(@PathVariable("id") int id) throws AdminNotFoundException {
        return adminService.getAdminById(id);
    }

    // Update an Admin
    @PutMapping("/updateAdmin/{id}")
    AdminDTO updateAdmin(@Valid @PathVariable int id, @RequestBody AdminDTO adminDTO) throws AdminNotFoundException {
        final Admin admin = converter.convertToAdminEntity(adminDTO);
        return adminService.updateAdmin(id, admin);
    }

    // Delete an Admin by ID
    @DeleteMapping("/deleteAdmin/{id}")
    String deleteAdmin(@PathVariable int id) {
        return adminService.deleteAdmin(id);
    }
}
