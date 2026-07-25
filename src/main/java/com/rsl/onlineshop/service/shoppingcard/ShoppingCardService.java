package com.rsl.onlineshop.service.shoppingcard;

import com.rsl.onlineshop.dto.request.ShoppingCardRequest;
import com.rsl.onlineshop.dto.response.ShoppingCardResponse;

public interface ShoppingCardService {

    ShoppingCardResponse addShoppingCard (ShoppingCardRequest shoppingCardRequest);
}
