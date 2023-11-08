package com.library.mgmt.system.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.library.mgmt.system.dao.BookRepository;
import com.library.mgmt.system.entity.Book;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
 // ... (Other test methods here)

    @Test
    public void testCreateBook() {
        // Create and save a book
        Book book = new Book();
        book.setTitle("The Alchemist");
        book.setAuthor("Paulo Coelho");
        book.setGenre("Fiction");
        book.setISBN("9780061122415");

        Book savedBook = bookRepository.save(book);
        assertNotNull(savedBook.getId());
    }

    @Test
    public void testGetAllBooks() {
        // Clear the database to ensure a clean state
        bookRepository.deleteAll();

        // Create and save multiple book entities
        Book book1 = new Book(1, "To Kill a Mockingbird", "Harper Lee","9780061122415", "Fiction",  "English", null, null, null);
        Book book2 = new Book(2, "1984", "George Orwell",  "9780451524935","Dystopian","English", null, null, null);
        Book book3 = new Book(3, "The Great Gatsby", "F. Scott Fitzgerald","9780743273565", "Classic","English",  null,  null, null);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        // Retrieve all books from the database
        List<Book> allBooks = bookRepository.findAll();

        // Assert that the list is not empty and contains the expected number of books
        assertNotNull(allBooks);
        assertEquals(3, allBooks.size());
    }

    @Test
    public void testUpdateBookById() {
        // Create and save a book
        Book book = new Book();
        book.setTitle("The Lord of the Rings");
        book.setAuthor("J.R.R. Tolkien");
        book.setGenre("Fantasy");
        book.setISBN("9780618640157");

        book = bookRepository.save(book);

        // Update the book's details
        int bookId = book.getId();
        Book updatedBook = bookRepository.findById(bookId).orElse(null);
        assertNotNull(updatedBook);

        // Modify the book's attributes
        updatedBook.setTitle("New Title"); // Update title
        updatedBook.setAuthor("New Author"); // Update author
        updatedBook.setGenre("New Genre"); // Update genre
        updatedBook.setISBN("1234567890"); // Update ISBN
        updatedBook.setLanguage("english");
        
        // Save the updated book
        updatedBook = bookRepository.save(updatedBook);

        // Retrieve the updated book from the database
        Book retrievedBook = bookRepository.findById(bookId).orElse(null);
        assertNotNull(retrievedBook);

        // Assert that the attributes have been updated
        assertEquals("New Title", retrievedBook.getTitle());
        assertEquals("New Author", retrievedBook.getAuthor());
        assertEquals("New Genre", retrievedBook.getGenre());
        assertEquals("1234567890", retrievedBook.getISBN());
    }
    
    @Test
    public void testGetBookById() {
        // Create and save a book
        Book book = new Book();
        book.setTitle("Sample Book Title");
        book.setAuthor("Sample Author");
        book.setISBN("1234567890");

        book = bookRepository.save(book);

        // Retrieve the book by ID
        Book retrievedBook = bookRepository.findById(book.getId()).orElse(null);

        // Assert that the retrieved book is not null and has the correct ID and attributes
        assertNotNull(retrievedBook);
        assertEquals(book.getId(), retrievedBook.getId());
        assertEquals("Sample Book Title", retrievedBook.getTitle());
        assertEquals("Sample Author", retrievedBook.getAuthor());
        assertEquals("1234567890", retrievedBook.getISBN());
    }


    @Test
    public void testDeleteBookById() {
        // Create and save a book
        Book book = new Book();
        book.setTitle("Harry Potter");
        book.setAuthor("J.K. Rowling");
        book.setGenre("Fantasy");
        book.setISBN("9780590353427");

        book = bookRepository.save(book);

        // Get the ID of the book to be deleted
        int bookId = book.getId();

        // Delete the book by ID
        bookRepository.deleteById(bookId);

        // Try to retrieve the deleted book by ID, and it should be null
        Book deletedBook = bookRepository.findById(bookId).orElse(null);
        assertNull(deletedBook);
    }
    
    @Test
    public void testGetBookByName() {
        // Create and save a book
        Book book = new Book();
        book.setTitle("Sample Book Title");
        book.setAuthor("Sample Author");
        book.setISBN("1234567890");

        book = bookRepository.save(book);

        // Retrieve the book by ID
        Book retrievedBook = bookRepository.findById(book.getId()).orElse(null);

        // Assert that the retrieved book is not null and has the correct ID and attributes
        assertNotNull(retrievedBook);
        assertEquals(book.getId(), retrievedBook.getId());
        assertEquals("Sample Book Title", retrievedBook.getTitle());
        assertEquals("Sample Author", retrievedBook.getAuthor());
        assertEquals("1234567890", retrievedBook.getISBN());
    }


}
