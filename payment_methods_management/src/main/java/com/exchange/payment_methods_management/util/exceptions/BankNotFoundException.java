package com.exchange.payment_methods_management.util.exceptions;

public class BankNotFoundException extends RuntimeException{
    public BankNotFoundException(String message) {
        super(message);
    }
}
