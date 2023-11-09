package com.library.mgmt.system.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.library.mgmt.system.entity.Faculty;
import com.library.mgmt.system.entity.Student;

import lombok.Data;

@Data 
//Lombok's @Data annotation will automatically gives required methods like constructors,getter and setter
public class LibrarianDTO //extends DemoDTO
{
	@NotNull(message="Name cannot be null")
	private String libName;
	//@NotNull
	@Email(message="Enter proper email")
	private String libEmail;
	@NotBlank(message="Enter proper username")
	private String libusername;
	@NotBlank(message="Enter proper password")
	private String libpassword;
	@NotNull
	@Pattern(regexp ="^\\d{10}$", message="Mobile number should be of 10 digits")
	private String libMobno;
	@NotBlank(message="Enter Right Gender")
	private String libGender;

	private List<Student> students;

    private List<Faculty> faculties;
	 

}
