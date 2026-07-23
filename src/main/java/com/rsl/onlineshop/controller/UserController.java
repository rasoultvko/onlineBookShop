package com.rsl.onlineshop.controller;

import com.rsl.onlineshop.dto.request.UserRequest;
import com.rsl.onlineshop.dto.response.UserResponse;
import com.rsl.onlineshop.model.UserssDetails;
import com.rsl.onlineshop.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/userha")
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest userRequest){
       return ResponseEntity.ok(userService.save(userRequest));
    }
}
