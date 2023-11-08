package com.library.mgmt.system.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.library.mgmt.system.dao.AdminRepository;
import com.library.mgmt.system.entity.Admin;

@SpringBootTest
public class AdminRepositoryTest 
{
	@Autowired
    private AdminRepository adminRepository;
	// ... (Other test methods here)

    @Test
    public void testCreateAdmin() {
    	 // Create and save an admin
        Admin admin = new Admin();
    
        admin.setAdminName("Rahul Patil");
        admin.setAdminEmail("admin1@example.com");
        admin.setAdminusername("admin1");
        admin.setAdminpassword("password1");
        

        Admin savedAdmin = adminRepository.save(admin);
        assertNotNull(savedAdmin.getId());
    }
    
    @Test
    public void testGetAllAdmins() {
    	
    	 // Clear the database to ensure a clean state
        adminRepository.deleteAll();
    	
        // Create and save multiple admin entities
        Admin admin1 = new Admin(1,"Rahul Patil","admin1@example.com","admin1", "password1");
        Admin admin2 = new Admin(2,"Pooja Raut","admin2@example.com","admin2", "password2");
        Admin admin3 = new Admin(3,"Aaditi Patel","admin3@example.com","admin3", "password3");

        adminRepository.save(admin1);
        adminRepository.save(admin2);
        adminRepository.save(admin3);

        // Retrieve all admins from the database
        List<Admin> allAdmins = adminRepository.findAll();

        // Assert that the list is not empty and contains the expected number of admins
        assertNotNull(allAdmins);
        assertEquals(3, allAdmins.size());
    }
    
    @Test
    public void testGetAdminById() {
        // Create and save an admin
        Admin admin = new Admin();
        admin.setAdminusername("admin3");
        admin.setAdminpassword("password3");
        admin.setAdminEmail("admin5@example.com");

        admin = adminRepository.save(admin);

        // Retrieve the admin by ID
        Admin retrievedAdmin = adminRepository.findById(admin.getId()).orElse(null);

        // Assert that the retrieved admin is not null and has the correct ID
        assertNotNull(retrievedAdmin);
        assertEquals(admin.getId(), retrievedAdmin.getId());
        assertEquals("admin3", retrievedAdmin.getAdminusername());
        assertEquals("password3", retrievedAdmin.getAdminpassword());
        assertEquals("admin5@example.com", retrievedAdmin.getAdminEmail());
    }
    
    @Test
    public void testUpdateAdminById() {
        // Create and save an admin
        Admin admin = new Admin();
        admin.setAdminusername("admin1");
        admin.setAdminpassword("password1");
        admin.setAdminEmail("admin1@example.com");
        admin.setAdminName("Rahul Patil");

        admin = adminRepository.save(admin);

        // Update the admin's details
        int adminId = admin.getId();
        Admin updatedAdmin = adminRepository.findById(adminId).orElse(null);
        assertNotNull(updatedAdmin);

        // Modify the admin's attributes
        updatedAdmin.setAdminusername("newAdmin1"); // Update username
        updatedAdmin.setAdminpassword("newPassword1"); // Update password
        updatedAdmin.setAdminEmail("newAdmin1@example.com"); // Update email
        updatedAdmin.setAdminName("newAdminname"); //update name
        
        // Save the updated admin
        updatedAdmin = adminRepository.save(updatedAdmin);

        // Retrieve the updated admin from the database
        Admin retrievedAdmin = adminRepository.findById(adminId).orElse(null);
        assertNotNull(retrievedAdmin);

        // Assert that the attributes have been updated
        assertEquals("newAdmin1", retrievedAdmin.getAdminusername());
        assertEquals("newPassword1", retrievedAdmin.getAdminpassword());
        assertEquals("newAdmin1@example.com", retrievedAdmin.getAdminEmail());
        assertEquals("newAdminname", retrievedAdmin.getAdminName());
    }
    
    @Test
    public void testDeleteAdminById() {
        // Create and save an admin
        Admin admin = new Admin();
        admin.setAdminusername("admin2");
        admin.setAdminpassword("password2");
        admin.setAdminEmail("admin2@example.com");

        admin = adminRepository.save(admin);

        // Get the ID of the admin to be deleted
        int adminId = admin.getId();

        // Delete the admin by ID
        adminRepository.deleteById(adminId);

        // Try to retrieve the deleted admin by ID, and it should be null
        Admin deletedAdmin = adminRepository.findById(adminId).orElse(null);
        assertNull(deletedAdmin);
    } 
    

}
