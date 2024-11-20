package com.library.book_service.services;

import com.library.book_service.entities.Books;
import com.library.book_service.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    // Fetch all books
    public List<Books> getAllBooks() {
        return bookRepo.findAll();
    }

    // Fetch book by ID
    public Optional<Books> getBookById(Integer id) {
        return bookRepo.findById(id);
    }

    // Add a new book
    public Books addBook(Books book) {
        return bookRepo.save(book);
    }

    // Delete a book by ID
    public void deleteBook(Integer id) {
        bookRepo.deleteById(id);
    }
}

