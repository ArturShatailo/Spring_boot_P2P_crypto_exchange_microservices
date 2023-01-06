package com.exchange.payment_methods_management.util.exceptions;

public class PayPalDetailsNotFoundException extends RuntimeException{
    public PayPalDetailsNotFoundException(String message) {
        super(message);
    }
}
