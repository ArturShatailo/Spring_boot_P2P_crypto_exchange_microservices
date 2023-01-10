package com.exchange.payment_system.service.validation.validationServices;

public interface AmountValidationService<W> {

    void isAmountEnough(W source, Double amount);

}
