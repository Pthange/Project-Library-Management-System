package com.library.mgmt.system.service;

import java.util.List;
import com.library.mgmt.system.dto.BookDTO;
import com.library.mgmt.system.entity.Book;

// Service interface for Book entities
public interface BookService 
{
    // Create a Book
    BookDTO createBook(Book book);

    // Get all Books
    List<BookDTO> getAllBooks();

    // Get a Book by ID
    BookDTO getBookById(int id);

    // Get a Book by Title
    BookDTO getBookByTitle(String title);

    // Update a Book by ID
    BookDTO updateBook(int id, Book book);

    // Delete a Book by ID
    String deleteBook(int id);
}
