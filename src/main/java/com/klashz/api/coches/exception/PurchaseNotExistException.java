package com.klashz.api.coches.exception;

public class PurchaseNotExistException extends RuntimeException{

    public PurchaseNotExistException(){
        super("la compra no existe");
    }
}
