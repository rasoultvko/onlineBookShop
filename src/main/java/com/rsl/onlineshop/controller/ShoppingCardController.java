package com.rsl.onlineshop.controller;

import com.rsl.onlineshop.dto.request.ShoppingCardRequest;
import com.rsl.onlineshop.dto.response.ShoppingCardResponse;
import com.rsl.onlineshop.model.ShoppingCard;
import com.rsl.onlineshop.service.shoppingcard.ShoppingCardService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/shoppingCard")
public class ShoppingCardController {

   private final ShoppingCardService shoppingCardService;

   @PostMapping
   public ResponseEntity<ShoppingCardResponse> addShoppingCard (@RequestBody @Valid ShoppingCardRequest shoppingCardRequest){

      return ResponseEntity.ok(shoppingCardService.addShoppingCard(shoppingCardRequest));
   }
}
