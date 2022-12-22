package com.exchange.payment_system.util.exceptions;

public class AccountWalletNotFoundException extends RuntimeException{
    public AccountWalletNotFoundException(String message) {
        super(message);
    }
}
