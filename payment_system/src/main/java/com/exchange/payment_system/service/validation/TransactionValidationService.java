package com.exchange.payment_system.service.validation;

public interface TransactionValidationService<T> {

    void validate(T T);

}
