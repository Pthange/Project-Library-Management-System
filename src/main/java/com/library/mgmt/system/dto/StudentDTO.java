package com.library.mgmt.system.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.library.mgmt.system.entity.Book;
import com.library.mgmt.system.entity.Transaction;

import lombok.Data;

@Data 
//Lombok's @Data annotation will automatically gives required methods like constructors,getter and setter
public class StudentDTO //extends DemoDTO
{

	@NotNull(message="Name cannot be null")
	private String studName;
	@NotNull
	@Email(message="Enter proper email")
	private String studEmail;
	@NotBlank(message="Enter proper username")
	private String userName;
	@NotBlank(message="Enter proper password")
	private String password;
	@NotBlank
	private String studDOB;
	@NotBlank(message="Enter Right Gender")
	private String studGender;
	@NotNull
	private String studAddress;
	@NotBlank
	private String studDepartment;
	@NotNull
	@Pattern(regexp ="^\\d{10}$", message="Mobile number should be of 10 digits")
	private String studMobno;

	private List<Book> books;
	
    private List<Transaction> transactions;

}
