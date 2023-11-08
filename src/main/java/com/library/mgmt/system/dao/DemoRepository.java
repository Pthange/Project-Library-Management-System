package com.library.mgmt.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.mgmt.system.entity.Demo;

public interface DemoRepository extends JpaRepository<Demo, Integer>{
	
	Demo findByDemoUsernameAndDemoPassword(String demoUsername, String demoPassword);
}
