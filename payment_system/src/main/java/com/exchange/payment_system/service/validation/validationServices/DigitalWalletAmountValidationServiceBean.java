package com.exchange.payment_system.service.validation.validationServices;

import com.exchange.payment_system.domain.wallets.DigitalWallet;
import com.exchange.payment_system.util.exceptions.NotEnoughFundsOnBalanceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DigitalWalletAmountValidationServiceBean implements AmountValidationService<DigitalWallet> {

    @Override
    public void isAmountEnough(DigitalWallet source, Double amount) {
        if (source.getBalance_available().compareTo(amount) < 0)
            throw new NotEnoughFundsOnBalanceException("Balance of the wallet: " + source.getNumber() + "is not enough");
    }
}
