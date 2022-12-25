package com.exchange.payment_system.util.exceptions;

public class P2PTransactionNotFoundException extends RuntimeException{
    public P2PTransactionNotFoundException(String message) {
        super(message);
    }
}
