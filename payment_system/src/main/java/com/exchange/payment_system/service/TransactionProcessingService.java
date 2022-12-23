package com.exchange.payment_system.service;

public interface TransactionProcessingService <T>{

    T create(T T);

    void accept(Long id);

    void decline(Long id);

}
