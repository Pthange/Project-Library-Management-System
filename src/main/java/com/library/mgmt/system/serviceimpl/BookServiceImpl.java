package com.library.mgmt.system.serviceimpl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.mgmt.system.dao.BookRepository;
import com.library.mgmt.system.dto.BookDTO;
import com.library.mgmt.system.entity.Book;
import com.library.mgmt.system.exception.ResourceNotFoundException;
import com.library.mgmt.system.service.BookService;
import com.library.mgmt.system.util.Converter;

@Service
public class BookServiceImpl implements BookService 
{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private Converter converter;
 // Dependency injection for Converter for conversion purposes

    // Creates a book
    @Override
    public BookDTO createBook(Book book) {
        // Set attributes specific to Book entity
        book.setTitle(book.getTitle());
        Book bookEntity = bookRepository.save(book);
        return converter.convertToBookDTO(bookEntity);
    }

    // Retrieves all books
    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        List<BookDTO> dtoList = new ArrayList<>();
        for (Book book : books) {
            dtoList.add(converter.convertToBookDTO(book));
        }

        return dtoList;
    }

    // Retrieves a book by its ID
    @Override
    public BookDTO getBookById(int id) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Book", "Id", id));
        return converter.convertToBookDTO(book);
    }
    
    // Retrieves a book by its title
    @Override
    public BookDTO getBookByTitle(String title) {
        Book book = bookRepository.findBytitle(title);
        return converter.convertToBookDTO(book);
    }

    // Updates a book by its ID
    @Override
    public BookDTO updateBook(int id, Book book) {
        Book bookEntity = bookRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Book", "Id", id));
        
        // Update attributes specific to Book entity
        book.setTitle(book.getTitle());
        Book updatedBook = bookRepository.save(bookEntity);
        return converter.convertToBookDTO(updatedBook);
    }

    // Deletes a book by its ID
    @Override
    public String deleteBook(int id) {
        bookRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Book", "Id", id));

        bookRepository.deleteById(id);
        return "Book deleted successfully!";
    }
}
