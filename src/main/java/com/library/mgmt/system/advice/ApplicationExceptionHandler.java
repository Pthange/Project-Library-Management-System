package com.library.mgmt.system.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.library.mgmt.system.exception.AdminNotFoundException;
import com.library.mgmt.system.exception.AuthorNotFoundException;
import com.library.mgmt.system.exception.BookNotFoundException;
import com.library.mgmt.system.exception.FacultyNotFoundException;
import com.library.mgmt.system.exception.LibrarianNotFoundException;
import com.library.mgmt.system.exception.StudentNotFoundException;
import com.library.mgmt.system.exception.TransactionNotFoundException;


@RestControllerAdvice
public class ApplicationExceptionHandler 
{
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex)
	{
		Map<String, String> errorMap= new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}
	
	//AdminNotFoundException
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(AdminNotFoundException.class)
	public Map<String,String> handleBusinessException(AdminNotFoundException ex)
	{
		Map<String, String> errorMap= new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
	}
	
	//BookNotFoundException
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(BookNotFoundException.class)
	public Map<String,String> handleBusinessException(BookNotFoundException ex)
	{
		Map<String, String> errorMap= new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
	}
	
	//AuthorNotFoundException
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(AuthorNotFoundException.class)
	public Map<String,String> handleBusinessException(AuthorNotFoundException ex)
	{
		Map<String, String> errorMap= new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
	}
	
	//FacultyNotFoundException
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(FacultyNotFoundException.class)
	public Map<String,String> handleBusinessException(FacultyNotFoundException ex)
	{
		Map<String, String> errorMap= new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
	}
	
	//LibrarianNotFoundException
		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler(LibrarianNotFoundException.class)
		public Map<String,String> handleBusinessException(LibrarianNotFoundException ex)
		{
			Map<String, String> errorMap= new HashMap<>();
			errorMap.put("errorMessage", ex.getMessage());
			return errorMap;
		}
		
		//StudentNotFoundException
		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler(StudentNotFoundException.class)
		public Map<String,String> handleBusinessException(StudentNotFoundException ex)
		{
			Map<String, String> errorMap= new HashMap<>();
			errorMap.put("errorMessage", ex.getMessage());
			return errorMap;
		}		
		
		//TransactionNotFoundException
				@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
				@ExceptionHandler(TransactionNotFoundException.class)
				public Map<String,String> handleBusinessException(TransactionNotFoundException ex)
				{
					Map<String, String> errorMap= new HashMap<>();
					errorMap.put("errorMessage", ex.getMessage());
					return errorMap;
				}		

}
