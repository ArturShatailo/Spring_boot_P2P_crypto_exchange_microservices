package com.exchange.payment_methods_management.util.exceptions;

public class BankDetailsNotFoundException extends RuntimeException{
    public BankDetailsNotFoundException(String message) {
        super(message);
    }
}
