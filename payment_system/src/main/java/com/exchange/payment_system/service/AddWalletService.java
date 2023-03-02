package com.exchange.payment_system.service;

public interface AddWalletService<W> {

    W addWallet(String email, Long id);

}
