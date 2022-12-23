package com.exchange.payment_system.service;

import com.exchange.payment_system.domain.WithdrawalRequest;

public interface WithdrawalRequestProcessingService {

    WithdrawalRequest create(WithdrawalRequest withdrawalRequest);

    void accept(Long id);

    void decline(Long id);

}
