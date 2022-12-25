package com.exchange.payment_system.util.exceptions;

public class AccountWalletExistsException extends RuntimeException{
    public AccountWalletExistsException(String message) {
        super(message);
    }
}
