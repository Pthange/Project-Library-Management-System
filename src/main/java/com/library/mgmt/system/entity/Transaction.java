package com.library.mgmt.system.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="BookTransaction_Details")
public class Transaction //extends Demo
{
	@Id   //Making id a primary key
	@GeneratedValue(strategy = GenerationType.AUTO) //Making id as auto generated
    @Column(name="TransactionID")
    private int id;
    private String borrowDate;
    private  String dueDate;
    private  String returnDate;
    private int total_fine;
    
    @ManyToOne
    private Student student;

    @ManyToOne
    private Faculty faculty;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "BookID")
    private Book book;
    
}