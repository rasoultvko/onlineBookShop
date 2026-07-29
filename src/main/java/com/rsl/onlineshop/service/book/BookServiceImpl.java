package com.rsl.onlineshop.service.book;

import com.rsl.onlineshop.dto.request.BookRequest;
import com.rsl.onlineshop.dto.response.BookResponse;
import com.rsl.onlineshop.exception.RuleException;
import com.rsl.onlineshop.model.Book;
import com.rsl.onlineshop.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    @Override
    public BookResponse save(BookRequest bookRequest) {
        Optional<Book> byName = bookRepository.findByName(bookRequest.getName());
        if (byName.isPresent())
            throw new RuleException("book.is.exist");
        Book save = bookRepository.save(createBook(bookRequest));
        return createBookResponse(save);

    }

    public Book findByIdBook (Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new RuleException("book.not.exist"));
        return book;
    }

    @Override
    @Transactional
    public void deleted(Long id) {
       Book book = findByIdBook(id);
       bookRepository.delete(book);

    }

    private Book createBook (BookRequest bookRequest){
      return   Book.builder()
                .name(bookRequest.getName())
                .price(bookRequest.getPrice())
                .build();
    }

    private BookResponse createBookResponse (Book book){
       return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .price(book.getPrice())
                .build();
    }
}
