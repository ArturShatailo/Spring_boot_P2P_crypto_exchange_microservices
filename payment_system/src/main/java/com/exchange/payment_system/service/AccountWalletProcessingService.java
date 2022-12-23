package com.exchange.payment_system.service;

import com.exchange.payment_system.domain.AccountWallet;

public interface AccountWalletProcessingService {

    void depositConfirmed(String accountWallet, Double amount, String email);

    AccountWallet addAccountWallet(String email, Long currency_id);
}
