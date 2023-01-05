package com.exchange.payment_methods_management.util.exceptions;

public class PaymentMethodNotFoundException extends RuntimeException{
    public PaymentMethodNotFoundException(String message) {
        super(message);
    }
}
