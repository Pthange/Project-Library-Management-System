package com.library.mgmt.system.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.mgmt.system.dao.DemoRepository;
import com.library.mgmt.system.entity.Demo;
import com.library.mgmt.system.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoRepository demoRepository;
    
    // Validates the provided username and password for login
    @Override
    public Demo login(String demoUsername, String demoPassword) {
        // Retrieve the demo entity based on the username and password
        Demo demo = demoRepository.findByDemoUsernameAndDemoPassword(demoUsername, demoPassword);
        return demo;
    }
}
