package com.exchange.payment_system.service.validation;

import com.exchange.payment_system.domain.WithdrawalRequest;

public interface WithdrawalRequestValidationService {

    void validate(WithdrawalRequest withdrawalRequest);

}
