package com.library.mgmt.system.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data 
//Lombok's @Data annotation will automatically gives required methods like constructors,getter and setter
public class AdminDTO //extends DemoDTO
{
	@NotBlank(message="Admin cannot be null")
	private String adminName;
    @NotNull
	@Email(message="Enter proper email")
	private String adminEmail;
	@NotBlank
	private String adminusername;
	@NotBlank
	private String adminpassword;
	
	
	
}
