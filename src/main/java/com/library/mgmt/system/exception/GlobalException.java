package com.library.mgmt.system.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice // This annotation is used to define a class that provides centralized exception handling for all @Controller classes.
public class GlobalException {

	// This class serves as a global exception handler for the library management system.
	
	// This method handles ResourceNotFoundExceptions specifically.
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundExHandling(ResourceNotFoundException exception, WebRequest request) {
		// Creating an instance of ErrorDetails to encapsulate error information.
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		// Returning a ResponseEntity with error details and an HTTP status code indicating 'Not Found'.
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
