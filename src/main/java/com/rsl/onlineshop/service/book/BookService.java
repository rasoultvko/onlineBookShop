package com.rsl.onlineshop.service.book;

import com.rsl.onlineshop.dto.request.BookRequest;
import com.rsl.onlineshop.dto.response.BookResponse;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    BookResponse save (BookRequest bookRequest);
}
