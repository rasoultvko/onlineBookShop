package com.rsl.onlineshop.repository;

import com.rsl.onlineshop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
