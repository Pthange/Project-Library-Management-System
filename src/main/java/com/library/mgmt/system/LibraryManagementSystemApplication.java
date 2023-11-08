package com.library.mgmt.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.library.mgmt.system.config.JwtFilter;

@SpringBootApplication
public class LibraryManagementSystemApplication {
	
	// Define a filter bean to register the JwtFilter
	@SuppressWarnings("rawtypes")
	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		// Create a FilterRegistrationBean
		final FilterRegistrationBean<JwtFilter> registrationBean=new FilterRegistrationBean<JwtFilter>();
		// Set the filter to JwtFilter
			registrationBean.setFilter(new JwtFilter());
			
			// Specify URL patterns to which the filter should be applied
			registrationBean.addUrlPatterns("/api/*");
			
			// Return the configured FilterRegistrationBean
			return registrationBean;
	
	}
	public static void main(String[] args) {
		
		// Start the Spring Boot application
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
		System.out.println("Welcome to Library Management system");
	}

}
