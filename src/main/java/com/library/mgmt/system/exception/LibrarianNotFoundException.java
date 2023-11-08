package com.library.mgmt.system.exception;

@SuppressWarnings("serial")
//Indicates that the compiler should suppress the warning related to the absence of serialVersionUID

//Represents a custom exception that signals the absence of a librarian in the system
public class LibrarianNotFoundException extends Exception 
{
 // Constructor to create a LibrarianNotFoundException with a custom error message
 public LibrarianNotFoundException(String message) 
 {
     // Calls the constructor of the Exception class and passes the error message
     super(message);
 }
}

