package com.library.book_service.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books_borrowed")
public class BooksBorrowed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer borrowId;

    // ManyToOne relationship to Book entity (representing the book being borrowed)
    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "bookId")  // foreign key to bookId in books table
    private Books book;  // This will reference the Book entity, not Integer

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "borrowDate")
    private Date borrowDate;

    @Column(name = "returnDate")
    private Date returnDate;

    // Getters and Setters
    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
