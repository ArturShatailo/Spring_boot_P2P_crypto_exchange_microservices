package com.exchange.payment_system.service;

public interface WalletProcessingService<W> {

    void depositConfirmed(String wallet, Double amount, String email);

    void withdrawalConfirmed(String wallet, Double amount, String email);

    W addWallet(String email, Long id);
}
