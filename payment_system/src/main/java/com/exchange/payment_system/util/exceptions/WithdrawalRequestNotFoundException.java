package com.exchange.payment_system.util.exceptions;

public class WithdrawalRequestNotFoundException extends RuntimeException{
    public WithdrawalRequestNotFoundException(String message) {
        super(message);
    }
}
