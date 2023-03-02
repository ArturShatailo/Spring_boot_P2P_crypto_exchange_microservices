package com.exchange.payment_system.service.validation.validationServices;

import com.exchange.payment_system.domain.wallets.AccountWallet;
import com.exchange.payment_system.util.exceptions.NotEnoughFundsOnBalanceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountWalletAmountValidationServiceBean implements AmountValidationService<AccountWallet> {

    @Override
    public void isAmountEnough(AccountWallet source, Double amount) {
        if (source.getBalance().compareTo(amount) < 0)
            throw new NotEnoughFundsOnBalanceException("Balance of the wallet: " + source.getNumber() + " is not enough");
    }
}
