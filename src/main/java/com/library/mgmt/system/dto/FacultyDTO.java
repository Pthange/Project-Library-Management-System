package com.library.mgmt.system.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.library.mgmt.system.entity.Book;
import com.library.mgmt.system.entity.Transaction;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data 
//Lombok's @Data annotation will automatically gives required methods like constructors,getter and setter
public class FacultyDTO //extends DemoDTO
{
	@NotNull
	private int id;
	@NotNull(message=" Faculty cannot be null")
	private String facName;
	@NotNull
	@Email(message="Enter proper email")
	private String facEmail;
	@NotBlank(message="Enter proper username")
	private String facusername;
	@NotBlank(message="Enter proper password")
	private String facpassword;
	@NotBlank
	private String facDOB;
	@NotBlank(message="Enter Right Gender")
	private String facGender;
	@NotNull
	private String facDepartment;
	@NotNull
	@Pattern(regexp ="^\\d{10}$", message="Mobile number should be of 10 digits")
	private String facMobno;

    private List<Book> books;

    private List<Transaction> transactions;
	

}
