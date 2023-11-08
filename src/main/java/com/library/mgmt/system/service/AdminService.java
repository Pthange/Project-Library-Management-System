package com.library.mgmt.system.service;

import java.util.List;
import com.library.mgmt.system.dto.AdminDTO;
import com.library.mgmt.system.entity.Admin;

// Service interface defining operations for Admin entities
public interface AdminService 
{
    // Create an Admin
    AdminDTO createAdmin(Admin admin);

    // Get all Admins
    List<AdminDTO> getAllAdmins();

    // Get an Admin by ID
    AdminDTO getAdminById(int id);

    // Update an Admin by ID
    AdminDTO updateAdmin(int id, Admin admin);

    // Delete an Admin by ID
    String deleteAdmin(int id);
}
