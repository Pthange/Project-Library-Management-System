package com.library.mgmt.system.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data               //Generate getter and setter methods for all the data members
@AllArgsConstructor  //Generates an all-args constructor
@NoArgsConstructor  //Generates a no-args constructor
@Entity              //Specifying class is an entity
@Table(name="Student")
public class Student 
{
	@Id   //Making id a primary key
	@GeneratedValue(strategy = GenerationType.AUTO) //Making id as auto generated
	@Column(name="StudentID")
	private int id;
	private String studName;
	private String studEmail;
	private String userName;
	private String password;
	private String studDOB;
	private String studGender;
	private String studAddress;
	private String studDepartment;
	private String studMobno;
	
	@OneToMany
	private List<Book> books;

	@OneToOne
	private Transaction transaction ;
	
	 @OneToOne
	 private Librarian librarian;

}
