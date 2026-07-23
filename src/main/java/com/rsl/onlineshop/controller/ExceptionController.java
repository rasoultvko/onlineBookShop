package com.rsl.onlineshop.controller;

import com.rsl.onlineshop.dto.response.ExceptionResponse;
import com.rsl.onlineshop.exception.RuleException;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(RuleException.class)
   public ResponseEntity<List<ExceptionResponse>> handlerRoleException(RuleException ruleException){
       return ResponseEntity
               .status(400)
               .body(Collections.singletonList(ruleExceptionToExceptionResponse(ruleException)));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionResponse>>handlerMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
       return ResponseEntity.status(401)
                .body(MethodArgumentNotValidExceptionToExceptionResponse(methodArgumentNotValidException));
    }


   /* private ExceptionResponse methodArgumentNotValidExceptionToExceptionResponse(MethodArgumentNotValidException methodArgumentNotValidException){
       return ExceptionResponse.builder()
                .message(methodArgumentNotValidException.getMessage())
                .code(methodArgumentNotValidException.getMessage())
                .build();
    }*/

    private List<ExceptionResponse> MethodArgumentNotValidExceptionToExceptionResponse(MethodArgumentNotValidException methodArgumentNotValidException){
        return methodArgumentNotValidException.getFieldErrors()
                .stream().map(error->
                        ExceptionResponse.builder()
                                .message(error.getDefaultMessage())
                                .code(error.getField())
                                .build()
                ).collect(Collectors.toList());
    }

    private ExceptionResponse ruleExceptionToExceptionResponse(RuleException ruleException){
        return ExceptionResponse.builder()
                .message(ruleException.getMessage())
                .code(ruleException.getMessage())
                .build();
    }
}
