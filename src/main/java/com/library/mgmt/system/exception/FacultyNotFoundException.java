package com.library.mgmt.system.exception;

//Indicates that the compiler should suppress the warning related to the absence of serialVersionUID
@SuppressWarnings("serial")

//Represents a custom exception that signifies the absence of a faculty member in the system
public class FacultyNotFoundException extends Exception 
{
 // Constructor to create a FacultyNotFoundException with a custom error message
 public FacultyNotFoundException(String message) 
 {
     // Calls the constructor of the Exception class and passes the error message
     super(message);
 }
}
