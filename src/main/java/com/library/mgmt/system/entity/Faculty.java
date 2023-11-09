package com.library.mgmt.system.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Data  //Generate getter and setter methods for all the data members
@AllArgsConstructor  //Generates an all-args constructor
@NoArgsConstructor  //Generates a no-args constructor
@Entity //Specifying class is an entity
@Table(name="Faculty")
public class Faculty //extends Demo
{
	@Id   //Making id a primary key
	@GeneratedValue(strategy = GenerationType.AUTO) //Making id as auto generated
	@Column(name="FacultyID")
	private int id;
	private String facName;
	private String facEmail;
	private String facusername;
	private String facpassword;
	private String facDOB;
	private String facGender;
	private String facDepartment;
	private String facMobno;
	
	@OneToMany
	private List<Book> books;

	 @OneToMany
	 private List<Transaction> transactions;


}
