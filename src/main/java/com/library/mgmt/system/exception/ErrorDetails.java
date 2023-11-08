package com.library.mgmt.system.exception;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// This class represents details of an error that occurred within the library management system.
@Setter
//These annotations automatically generate getter and setter methods for the field
@Getter

//@NoArgsConstructor creates a no-args constructor for the class
@NoArgsConstructor
//@AllArgsConstructor creates an all-args constructor for the class
@AllArgsConstructor
public class ErrorDetails {

    private Date timeStamp;  // Timestamp indicating when the error occurred
    private String mesage;   // A message describing the error
    private String details;  // Additional details or information about the error
    
    // Constructor to initialize ErrorDetails with all fields
    // Used to set all the fields while creating an instance of ErrorDetails
    // @param timeStamp - the timestamp of the error
    // @param message - the description of the error
    // @param details - additional information about the error
    
    // Getters and Setters for the ErrorDetails fields
    // @Getter annotation from Lombok generates the getter methods for all fields
    // @Setter annotation from Lombok generates the setter methods for all fields
}
