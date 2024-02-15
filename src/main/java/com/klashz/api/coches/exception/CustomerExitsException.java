package com.klashz.api.coches.exception;

public class CustomerExitsException extends RuntimeException{

    public CustomerExitsException(){
        super("Ya existe un cliente con estos datos");
    }
}
