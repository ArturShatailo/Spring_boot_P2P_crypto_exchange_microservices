package com.exchange.payment_system.util.exceptions;

public class ClientIsNotVerifiedException extends RuntimeException{
    public ClientIsNotVerifiedException(String message) {
        super(message);
    }
}
