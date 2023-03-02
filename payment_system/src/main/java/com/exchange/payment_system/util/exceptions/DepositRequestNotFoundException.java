package com.exchange.payment_system.util.exceptions;

public class DepositRequestNotFoundException extends RuntimeException{
    public DepositRequestNotFoundException(String message) {
        super(message);
    }
}
