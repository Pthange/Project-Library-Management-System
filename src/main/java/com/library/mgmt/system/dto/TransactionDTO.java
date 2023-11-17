package com.library.mgmt.system.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.library.mgmt.system.entity.Book;
import com.library.mgmt.system.entity.Faculty;
import com.library.mgmt.system.entity.Student;

import lombok.Data;

@Data 
//Lombok's @Data annotation will automatically gives required methods like constructors,getter and setter
public class TransactionDTO //extends DemoDTO
{ 
	@NotNull
     private String booktitle;
	@NotNull
    private  String name;  //name should be faculty name or student name

	@NotBlank(message="cannot be null")
    private String borrowDate;
	
	@NotBlank(message="cannot be null")
    private String dueDate;
	
	private String returnDate;
    
    private int total_fine;
    
    private Student student;

    private Faculty faculty;

    private Book book;

}
