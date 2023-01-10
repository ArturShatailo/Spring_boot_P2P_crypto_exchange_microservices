package com.exchange.payment_system.service.validation.validationServices;

public interface WalletValidationService<W> {

    W isAvailableWallet(String email, String number);

}
