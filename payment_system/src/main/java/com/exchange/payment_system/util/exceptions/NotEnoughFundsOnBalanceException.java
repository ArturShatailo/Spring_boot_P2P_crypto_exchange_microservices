package com.exchange.payment_system.util.exceptions;

public class NotEnoughFundsOnBalanceException extends RuntimeException{
    public NotEnoughFundsOnBalanceException(String message) {
        super(message);
    }
}
