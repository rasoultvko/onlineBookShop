package com.rsl.onlineshop.repository;

import com.rsl.onlineshop.dto.request.BookRequest;
import com.rsl.onlineshop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {

    Optional<Book> findByName (String name);
}
