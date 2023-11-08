package com.library.mgmt.system.exception;

//Indicates that the compiler should suppress the warning related to the absence of serialVersionUID
@SuppressWarnings("serial")
public class BookNotFoundException extends Exception 
{
 // Constructor for BookNotFoundException class
   public BookNotFoundException(String message) 
   {
     // Calls the constructor of the Exception class and passes the error message
     super(message);
    }
}
