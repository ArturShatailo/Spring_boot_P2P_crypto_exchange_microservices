package com.exchange.payment_methods_management.util.exceptions;

public class CardDetailsNotFoundException extends RuntimeException{
    public CardDetailsNotFoundException(String message) {
        super(message);
    }
}
