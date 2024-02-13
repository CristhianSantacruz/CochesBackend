package com.klashz.api.coches.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptions {

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<Map<String,String>> emailException(EmailException emailException){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
          Collections.singletonMap("ERROR",emailException.getMessage())
        );
    }
}
