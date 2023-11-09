package com.library.mgmt.system.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.library.mgmt.system.entity.Faculty;
import com.library.mgmt.system.entity.Student;
import lombok.Data;

@Data 
//Lombok's @Data annotation will automatically gives required methods like constructors,getter and setter
public class BookDTO //extends DemoDTO
{
	@NotNull(message="Book Title cannot be null")
	private String title;
	@NotNull(message="Author cannot be null")
	private String author;
	@NotBlank
	private String ISBN;
	@NotBlank(message="Enter Right Genre")
	private String genre;
	@NotBlank(message="Enter Right Book Language")
	private String language;
	
	private Student student;  
	// Many-to-One relationship with the Student entity. 
	
	private Faculty faculty;  
	// Many-to-One relationship with the Faculty entity. 
	

}
