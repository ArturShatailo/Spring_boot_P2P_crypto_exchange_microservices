package com.exchange.payment_system.service;

import com.exchange.payment_system.domain.DepositRequest;

public interface DepositRequestProcessingService {

    DepositRequest create(DepositRequest depositRequest);

    void accept(Long id);

    void decline(Long id);

}
