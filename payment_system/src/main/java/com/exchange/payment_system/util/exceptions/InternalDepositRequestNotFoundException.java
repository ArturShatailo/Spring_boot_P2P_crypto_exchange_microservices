package com.exchange.payment_system.util.exceptions;

public class InternalDepositRequestNotFoundException extends RuntimeException{
    public InternalDepositRequestNotFoundException(String message) {
        super(message);
    }
}
