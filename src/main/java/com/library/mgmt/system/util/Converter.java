package com.library.mgmt.system.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.library.mgmt.system.dto.AdminDTO;
import com.library.mgmt.system.dto.AuthorDTO;
import com.library.mgmt.system.dto.BookDTO;
import com.library.mgmt.system.dto.FacultyDTO;
import com.library.mgmt.system.dto.LibrarianDTO;
import com.library.mgmt.system.dto.StudentDTO;
import com.library.mgmt.system.dto.TransactionDTO;
import com.library.mgmt.system.entity.Admin;
import com.library.mgmt.system.entity.Author;
import com.library.mgmt.system.entity.Book;
import com.library.mgmt.system.entity.Faculty;
import com.library.mgmt.system.entity.Librarian;
import com.library.mgmt.system.entity.Student;
import com.library.mgmt.system.entity.Transaction;

@Component
//Indicates that this class will be automatically detected and registered as a Spring bean
public class Converter 
{
	// Convert from StudentDTO to Student entity
	public Student convertToStudentEntity(StudentDTO studentDTO) {
	    // Create a new Student entity
	    Student student = new Student();
	    
	    // Check if the StudentDTO is not null before performing the conversion
	    if (studentDTO != null) {
	        // Copy properties from StudentDTO to Student entity
	        BeanUtils.copyProperties(studentDTO, student);
	    }
	    // Return the Student entity
	    return student;
	}

	// Convert from Student entity to StudentDTO
	public StudentDTO convertToStudentDTO(Student student) {
	    // Create a new StudentDTO
	    StudentDTO studentDTO = new StudentDTO();
	    
	    // Check if the Student entity is not null before performing the conversion
	    if (student != null) {
	        // Copy properties from Student entity to StudentDTO
	        BeanUtils.copyProperties(student, studentDTO);
	    }	    
	    // Return the StudentDTO
	    return studentDTO;
	}

	
	// Convert from AdminDTO to Admin entity
	public Admin convertToAdminEntity(AdminDTO adminDTO) {
	    // Create a new Admin entity
	    Admin admin = new Admin();
	    
	    // Check if the AdminDTO is not null before performing the conversion
	    if (adminDTO != null) {
	        // Copy properties from AdminDTO to Admin entity
	        BeanUtils.copyProperties(adminDTO, admin);
	    }	    
	    // Return the Admin entity
	    return admin;
	}

	// Convert from Admin entity to AdminDTO
	public AdminDTO convertToAdminDTO(Admin admin) {
	    // Create a new AdminDTO
	    AdminDTO adminDTO = new AdminDTO();
	    
	    // Check if the Admin entity is not null before performing the conversion
	    if (admin != null) {
	        // Copy properties from Admin entity to AdminDTO
	        BeanUtils.copyProperties(admin, adminDTO);
	    }	    
	    // Return the AdminDTO
	    return adminDTO;
	}
   
	// Convert from AuthorDTO to Author entity
	public Author convertToAuthorEntity(AuthorDTO authorDTO) {
	    // Create a new Author entity
	    Author author = new Author();
	    
	    // Check if the AuthorDTO is not null before performing the conversion
	    if (authorDTO != null) {
	        // Copy properties from AuthorDTO to Author entity
	        BeanUtils.copyProperties(authorDTO, author);
	    }
	    
	    // Return the Author entity
	    return author;
	}

	// Convert from Author entity to AuthorDTO
	public AuthorDTO convertToAuthorDTO(Author author) {
	    // Create a new AuthorDTO
	    AuthorDTO authorDTO = new AuthorDTO();
	    
	    // Check if the Author entity is not null before performing the conversion
	    if (author != null) {
	        // Copy properties from Author entity to AuthorDTO
	        BeanUtils.copyProperties(author, authorDTO);
	    }
	    
	    // Return the AuthorDTO
	    return authorDTO;
	}
 
	// Convert from BookDTO to Book entity
	public Book convertToBookEntity(BookDTO bookDTO) {
	    // Create a new Book entity
	    Book book = new Book();
	    
	    // Check if the BookDTO is not null before performing the conversion
	    if (bookDTO != null) {
	        // Copy properties from BookDTO to Book entity
	        BeanUtils.copyProperties(bookDTO, book);
	    }
	    
	    // Return the Book entity
	    return book;
	}

	// Convert from Book entity to BookDTO
	public BookDTO convertToBookDTO(Book book) {
	    // Create a new BookDTO
	    BookDTO bookDTO = new BookDTO();
	    
	    // Check if the Book entity is not null before performing the conversion
	    if (book != null) {
	        // Copy properties from Book entity to BookDTO
	        BeanUtils.copyProperties(book, bookDTO);
	    }
	    
	    // Return the BookDTO
	    return bookDTO;
	}
	
	// Convert from TransactionDTO to Transaction entity
	public Transaction convertToTransactionEntity(TransactionDTO transactionDTO) {
	    // Create a new Transaction entity
	    Transaction transaction = new Transaction();
	    
	    // Check if the TransactionDTO is not null before performing the conversion
	    if (transactionDTO != null) {
	        // Copy properties from TransactionDTO to Transaction entity
	        BeanUtils.copyProperties(transactionDTO, transaction);
	    }
	    
	    // Return the Transaction entity
	    return transaction;
	}

	// Convert from Transaction entity to TransactionDTO
	public TransactionDTO convertToTransactionDTO(Transaction transaction) {
	    // Create a new TransactionDTO
	    TransactionDTO transactionDTO = new TransactionDTO();
	    
	    // Check if the Transaction entity is not null before performing the conversion
	    if (transaction != null) {
	        // Copy properties from Transaction entity to TransactionDTO
	        BeanUtils.copyProperties(transaction, transactionDTO);
	    }
	    
	    // Return the TransactionDTO
	    return transactionDTO;
	}

	// Convert from FacultyDTO to Faculty entity
	public Faculty convertToFacultyEntity(FacultyDTO facultyDTO) {
	    // Create a new Faculty entity
	    Faculty faculty = new Faculty();
	    
	    // Check if the FacultyDTO is not null before performing the conversion
	    if (facultyDTO != null) {
	        // Copy properties from FacultyDTO to Faculty entity
	        BeanUtils.copyProperties(facultyDTO, faculty);
	        // You may need to copy additional properties if necessary
	    }
	    
	    // Return the Faculty entity
	    return faculty;
	}

	// Convert from Faculty entity to FacultyDTO
	public FacultyDTO convertToFacultyDTO(Faculty faculty) {
	    // Create a new FacultyDTO
	    FacultyDTO facultyDTO = new FacultyDTO();
	    
	    // Check if the Faculty entity is not null before performing the conversion
	    if (faculty != null) {
	        // Copy properties from Faculty entity to FacultyDTO
	        BeanUtils.copyProperties(faculty, facultyDTO);
	        // You may need to copy additional properties if necessary
	    }
	    
	    // Return the FacultyDTO
	    return facultyDTO;
	}

	// Convert from LibrarianDTO to Librarian entity
	public Librarian convertToLibrarianEntity(LibrarianDTO librarianDTO) {
	    // Create a new Librarian entity
	    Librarian librarian = new Librarian();
	    
	    // Check if the LibrarianDTO is not null before performing the conversion
	    if (librarianDTO != null) {
	        // Copy properties from LibrarianDTO to Librarian entity
	        BeanUtils.copyProperties(librarianDTO, librarian);
	    }
	    
	    // Return the Librarian entity
	    return librarian;
	}

	// Convert from Librarian entity to LibrarianDTO
	public LibrarianDTO convertToLibrarianDTO(Librarian librarian) {
	    // Create a new LibrarianDTO
	    LibrarianDTO librarianDTO = new LibrarianDTO();
	    
	    // Check if the Librarian entity is not null before performing the conversion
	    if (librarian != null) {
	        // Copy properties from Librarian entity to LibrarianDTO
	        BeanUtils.copyProperties(librarian, librarianDTO);
	    }
	    
	    // Return the LibrarianDTO
	    return librarianDTO;
	}

}  
 