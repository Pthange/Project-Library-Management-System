package com.library.mgmt.system.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.mgmt.system.dao.AdminRepository;
import com.library.mgmt.system.dto.AdminDTO;
import com.library.mgmt.system.entity.Admin;
import com.library.mgmt.system.exception.ResourceNotFoundException;
import com.library.mgmt.system.service.AdminService;
import com.library.mgmt.system.util.Converter;

@Service
//Service class responsible for implementing methods for Admin entities
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;    // Dependency injection for AdminRepository

    @Autowired
    private Converter converter;  // Dependency injection for Converter for conversion purposes

    // Method to create an Admin
    @Override
    public AdminDTO createAdmin(Admin admin) {
        admin.setAdminusername(admin.getAdminusername());
        admin.setAdminpassword(admin.getAdminpassword());
        // Set other attributes specific to Admin entity

        Admin adminEntity = adminRepository.save(admin);
        return converter.convertToAdminDTO(adminEntity);
    }

    // Method to get all Admins
    @Override
    public List<AdminDTO> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();

        List<AdminDTO> dtoList = new ArrayList<>();
        for (Admin admin : admins) {
            dtoList.add(converter.convertToAdminDTO(admin));
        }

        return dtoList;
    }

    // Method to get an Admin by ID
    @Override
    public AdminDTO getAdminById(int id) {
        Admin admin = adminRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Admin", "Id", id));
        return converter.convertToAdminDTO(admin);
    }

    // Method to update an Admin by ID
    @Override
    public AdminDTO updateAdmin(int id, Admin admin) {
        Admin adminEntity = adminRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Admin", "Id", id));
        
        adminEntity.setAdminEmail(admin.getAdminEmail());
        adminEntity.setAdminName(admin.getAdminName());
       
        // Update other attributes specific to Admin entity

        Admin updatedAdmin = adminRepository.save(adminEntity);
        return converter.convertToAdminDTO(updatedAdmin);
    }

    // Method to delete an Admin by ID
    @Override
    public String deleteAdmin(int id) {
        adminRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Admin", "Id", id));

        adminRepository.deleteById(id);
        return "Admin deleted successfully!";
    }
}
