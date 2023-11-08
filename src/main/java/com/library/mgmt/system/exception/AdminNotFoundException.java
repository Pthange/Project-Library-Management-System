package com.library.mgmt.system.exception;

@SuppressWarnings("serial")
//Indicates that the compiler should suppress the warning related to the absence of serialVersionUID
public class AdminNotFoundException extends Exception{

	    // Constructor for AdminNotFoundException class
    public AdminNotFoundException(String message) {
        // Calls the constructor of the Exception class and passes the error message
        super(message);
    }
}
