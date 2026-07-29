package com.rsl.onlineshop.controller;

import com.rsl.onlineshop.dto.request.BookRequest;
import com.rsl.onlineshop.dto.response.BookResponse;
import com.rsl.onlineshop.model.Book;
import com.rsl.onlineshop.service.book.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

   private final BookService bookService;

   @PostMapping
    public ResponseEntity<BookResponse> saveBook (@RequestBody @Valid BookRequest bookRequest){
       return ResponseEntity.ok(bookService.save(bookRequest));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Book> findByIdBook (@PathVariable Long id){
     return   ResponseEntity.ok(bookService.findByIdBook(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleted(id);
        return ResponseEntity.ok().build();
    }
}
