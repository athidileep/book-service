package com.library.book_service.controllers;

import com.library.book_service.entities.Books;
import com.library.book_service.repos.BooksBorrowedRepo;
import com.library.book_service.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BooksBorrowedRepo booksBorrowedRepository;

    // GET /books
    @GetMapping
    public ResponseEntity<List<Books>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // GET /books/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /books
    @PostMapping
    public ResponseEntity<Books> addBook(@RequestBody Books book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    // DELETE /books/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // Get all books currently borrowed by a specific user
    @GetMapping("/user/{userId}")
    public List<String> getBooksBorrowedByUser(@PathVariable int userId) {
        return booksBorrowedRepository.findByUserIdAndReturnDateIsNull(userId)
                .stream()
                .map(borrowed -> {
                    Books book = bookService.getBookById(borrowed.getBook().getBookId()).orElse(null);
                    return book != null ? book.getBookName() : null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}

