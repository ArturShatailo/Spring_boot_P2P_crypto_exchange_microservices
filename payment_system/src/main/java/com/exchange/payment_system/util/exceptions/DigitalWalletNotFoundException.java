package com.exchange.payment_system.util.exceptions;

public class DigitalWalletNotFoundException extends RuntimeException{
    public DigitalWalletNotFoundException(String message) {
        super(message);
    }
}
