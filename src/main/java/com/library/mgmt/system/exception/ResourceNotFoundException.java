package com.library.mgmt.system.exception;

// This class represents an exception for when a resource is not found within the library management system.
public class ResourceNotFoundException extends RuntimeException 
{
	// Unique identifier for ensuring the integrity of serialized objects during deserialization
	private static final long serialVersionUID = 1L;

	// Name of the resource not found
	private String resourceName;

	// Name of the field associated with the resource
	private String fieldName;

	// Value of the field associated with the resource
	private Object fieldValue;

	// Constructor for ResourceNotFoundException
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) 
	{
		// Calling the constructor of the parent class (RuntimeException) with a formatted error message
		super(String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue));
	
		// Set the resource name, field name, and field value for the exception context
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
