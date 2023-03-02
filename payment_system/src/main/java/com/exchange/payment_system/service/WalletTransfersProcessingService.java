package com.exchange.payment_system.service;

public interface WalletTransfersProcessingService<W> {

    void depositConfirmed(String wallet, Double amount, String email);

    void withdrawalConfirmed(String wallet, Double amount, String email);
}
