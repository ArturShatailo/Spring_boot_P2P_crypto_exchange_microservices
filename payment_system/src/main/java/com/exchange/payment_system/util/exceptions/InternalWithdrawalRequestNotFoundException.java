package com.exchange.payment_system.util.exceptions;

public class InternalWithdrawalRequestNotFoundException extends RuntimeException{
    public InternalWithdrawalRequestNotFoundException(String message) {
        super(message);
    }
}
