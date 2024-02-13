package com.klashz.api.coches.exception;

public class EmailException extends RuntimeException{

    public EmailException(){
        super("El email no tiene el formato requerido");
    }
}
