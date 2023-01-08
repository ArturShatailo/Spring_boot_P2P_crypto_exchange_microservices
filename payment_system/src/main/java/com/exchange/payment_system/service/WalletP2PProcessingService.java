package com.exchange.payment_system.service;

public interface WalletP2PProcessingService {

    void p2pDepositConfirmed(String wallet, Double amount, String email);

    void p2pWithdrawalConfirmed(String wallet, Double amount, String email);
}
