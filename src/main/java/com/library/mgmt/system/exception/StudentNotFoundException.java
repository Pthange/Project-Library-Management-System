package com.library.mgmt.system.exception;
@SuppressWarnings("serial")
//Indicates that the compiler should suppress the warning related to the absence of serialVersionUID

//Represents a custom exception to handle cases when a student is not found in the system
public class StudentNotFoundException extends Exception 
{
 // Constructor to create a StudentNotFoundException with a custom error message
 public StudentNotFoundException(String message)
 {
     // Calls the constructor of the Exception class and passes the error message
     super(message);
 }
}

