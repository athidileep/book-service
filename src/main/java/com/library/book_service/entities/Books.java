package com.library.book_service.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private Integer bookId;  // Changed to Integer for consistency with @GeneratedValue
    @Column(name = "bookName")
    private String bookName;
    @Column(name = "genre")
    private String genre;
    @Column(name = "totalNumberOfCopies")
    private Integer totalNumberOfCopies;  // Changed to Integer to match type
    @Column(name = "numberOfCopiesBorrowed")
    private Integer numberOfCopiesBorrowed;  // Changed to Integer to match type
    @Column(name = "acquiredDate")
    private Date acquiredDate;

    // Getters and Setters

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getTotalNumberOfCopies() {
        return totalNumberOfCopies;
    }

    public void setTotalNumberOfCopies(Integer totalNumberOfCopies) {
        this.totalNumberOfCopies = totalNumberOfCopies;
    }

    public Integer getNumberOfCopiesBorrowed() {
        return numberOfCopiesBorrowed;
    }

    public void setNumberOfCopiesBorrowed(Integer numberOfCopiesBorrowed) {
        this.numberOfCopiesBorrowed = numberOfCopiesBorrowed;
    }

    public Date getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(Date acquiredDate) {
        this.acquiredDate = acquiredDate;
    }
}
