package com.klashz.api.coches.exception;

public class CustomerNotExistsException extends RuntimeException{

    public CustomerNotExistsException(){
        super("No existe este cliente en la base de datos");
    }
}
