package com.library.book_service.repos;

import com.library.book_service.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Books, Integer> {
    // JpaRepository provides all basic CRUD operations.
}
