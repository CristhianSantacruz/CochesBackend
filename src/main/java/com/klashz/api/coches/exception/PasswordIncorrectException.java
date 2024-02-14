package com.klashz.api.coches.exception;

public class PasswordIncorrectException extends RuntimeException{

    public PasswordIncorrectException(){
        super("Las contrasenias no son correctas");
    }
}
