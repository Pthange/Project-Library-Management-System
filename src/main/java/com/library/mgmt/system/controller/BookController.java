package com.library.mgmt.system.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.mgmt.system.dto.BookDTO;
import com.library.mgmt.system.entity.Book;
import com.library.mgmt.system.exception.BookNotFoundException;
import com.library.mgmt.system.service.BookService;
import com.library.mgmt.system.util.Converter;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private Converter converter;

    // to create a book
    @PostMapping("/createBook")
    ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO) throws BookNotFoundException {
        final Book book = converter.convertToBookEntity(bookDTO);
        return new ResponseEntity<BookDTO>(bookService.createBook(book), HttpStatus.CREATED);
    }

    //to get all books
    @GetMapping("/getAllBooks")
    List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    //get a book by its ID
    @GetMapping("/getBookById/{id}")
    BookDTO getBookById(@PathVariable("id") int id) throws BookNotFoundException {
        return bookService.getBookById(id);
    }
    
    //to get a book by its title
    @GetMapping("/getBookByTitle/{title}")
    BookDTO getBookByTitle(@PathVariable("title") String title) throws BookNotFoundException {
        return bookService.getBookByTitle(title);
    }

    //to update a book
    @PutMapping("/updateBook/{id}")
    BookDTO updateBook(@Valid @PathVariable int id, @RequestBody BookDTO bookDTO) throws BookNotFoundException {
        final Book book = converter.convertToBookEntity(bookDTO);
        return bookService.updateBook(id, book);
    }

    //to delete a book by its ID
    @DeleteMapping("/deleteBook/{id}")
    String deleteBook(@PathVariable int id) {
        return bookService.deleteBook(id);
    }
}
