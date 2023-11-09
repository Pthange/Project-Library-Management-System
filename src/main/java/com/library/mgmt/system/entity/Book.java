package com.library.mgmt.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name="Book")
public class Book //extends Demo
{
	@Id   //Making id a primary key
	@GeneratedValue(strategy = GenerationType.AUTO) //Making id as auto generated
	@Column(name="BookID")
	private int id;
	private String title;
	private String author;
	private String ISBN;
	private String genre;
	private String language;
	
	@ManyToOne
    private Student student;

    @ManyToOne
    private Faculty faculty;
    

}
