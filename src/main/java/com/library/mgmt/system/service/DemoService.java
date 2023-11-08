package com.library.mgmt.system.service;

import com.library.mgmt.system.entity.Demo;

// Service interface for handling Demo entity
public interface DemoService {

    // Method to login with username and password for Demo entity
    public Demo login(String demoUsername, String demoPassword);
}
