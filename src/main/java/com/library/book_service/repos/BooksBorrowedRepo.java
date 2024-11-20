package com.library.book_service.repos;

import com.library.book_service.entities.BooksBorrowed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksBorrowedRepo extends JpaRepository<BooksBorrowed, Integer> {
    List<BooksBorrowed> findByUserIdAndReturnDateIsNull(int userId);
}
