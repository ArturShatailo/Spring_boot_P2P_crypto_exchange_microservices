package com.exchange.payment_system.service;

public interface DigitalWalletHoldFundsService {

    void p2pDigitalWalletHoldFunds(String email, Double amount, String wallet);

}
