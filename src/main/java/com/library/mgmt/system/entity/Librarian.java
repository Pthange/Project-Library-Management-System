package com.library.mgmt.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="Librarian")
public class Librarian //extends Demo
{
	@Id   //Making id a primary key
	@GeneratedValue(strategy = GenerationType.AUTO) //Making id as auto generated
	@Column(name="LibrarianID")
	private int id;
	private String libName;
	private String libEmail;
	private String libusername;
	private String libpassword;
	private String libMobno;
	private String libGender;
	
	 @OneToOne
	  private Student students;

	 @OneToOne
	 private Faculty faculties;
	
	

}