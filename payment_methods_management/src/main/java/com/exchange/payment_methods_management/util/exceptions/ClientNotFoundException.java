package com.exchange.payment_methods_management.util.exceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String message) {
        super(message);
    }
}
