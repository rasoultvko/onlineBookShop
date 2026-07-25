package com.rsl.onlineshop.service.shoppingcard;

import com.rsl.onlineshop.dto.request.ShoppingCardRequest;
import com.rsl.onlineshop.dto.response.ShoppingCardResponse;
import com.rsl.onlineshop.exception.RuleException;
import com.rsl.onlineshop.model.*;
import com.rsl.onlineshop.repository.BookRepository;
import com.rsl.onlineshop.repository.FactorRepository;
import com.rsl.onlineshop.repository.ShoppingCardRepository;
import com.rsl.onlineshop.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ShoppingCardServiceImpl implements ShoppingCardService{
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final FactorRepository factorRepository;
    private final ShoppingCardRepository shoppingCardRepository;

    public ShoppingCardServiceImpl(UserRepository userRepository, BookRepository bookRepository, FactorRepository factorRepository, ShoppingCardRepository shoppingCardRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.factorRepository = factorRepository;
        this.shoppingCardRepository = shoppingCardRepository;
    }

    @Transactional
    @Override
    public ShoppingCardResponse addShoppingCard(ShoppingCardRequest shoppingCardRequest) {
        UserssDetails user = userRepository.findById(shoppingCardRequest.getUserId())
                .orElseThrow(()-> new RuleException("user.not.exist"));

        Book book = bookRepository.findById(shoppingCardRequest.getBookId())
                .orElseThrow(()-> new RuleException("book.not.found"));

       Optional<Factor> byId = factorRepository.findByUserssDetailsAndPayed(user,Payed.UNPAYED);
       Factor factor;
        factor = byId.orElseGet(() -> createFactor(user));
        factorRepository.save(factor);
        ShoppingCard shoppingCard = createShoppingCard(shoppingCardRequest,book,factor);

        return createShoppingCardResponse(shoppingCardRepository.save(shoppingCard));

}

    private ShoppingCardResponse createShoppingCardResponse(ShoppingCard shoppingCard) {
      return   ShoppingCardResponse.builder()
                .shoppingCard(shoppingCard.getId())
                .factorId(shoppingCard.getFactor().getId())
                .build();
    }

    private ShoppingCard createShoppingCard(ShoppingCardRequest shoppingCardRequest, Book book, Factor factor) {
       return ShoppingCard.builder()
                .book(book)
                .factor(factor)
                .count(shoppingCardRequest.getCount())
                .build();
    }

    private Factor createFactor(UserssDetails userssDetails){
        return Factor.builder()
            .userssDetails(userssDetails)
            .payed(Payed.UNPAYED)
            .build();
    }
}
