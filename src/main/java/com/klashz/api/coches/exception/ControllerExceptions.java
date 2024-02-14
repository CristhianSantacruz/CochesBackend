package com.klashz.api.coches.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptions {

    @ExceptionHandler({EmailException.class , PurchaseNotExistException.class,CustomerNotExistsException.class,CustomerExitsException.class,PasswordIncorrectException.class})
    public ProblemDetail customerNotExits(RuntimeException runtimeException){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                runtimeException.getMessage());
    }
}
