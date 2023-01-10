package com.exchange.payment_system.service.validation;

import com.exchange.payment_system.domain.wallets.AccountWallet;
import com.exchange.payment_system.domain.CryptoCurrency;
import com.exchange.payment_system.domain.wallets.DigitalWallet;
import com.exchange.payment_system.domain.transactions.InternalDeposit;
import com.exchange.payment_system.service.validation.validationServices.AmountValidationService;
import com.exchange.payment_system.service.validation.validationServices.CurrenciesValidation;
import com.exchange.payment_system.service.validation.validationServices.WalletValidationService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InternalDepositValidationServiceBean implements TransactionValidationService<InternalDeposit>{

    private final CurrenciesValidation<CryptoCurrency> currenciesValidation;

    private final WalletValidationService<DigitalWallet> digitalWalletValidation;

    private final WalletValidationService<AccountWallet> accountWalletValidation;

    private final AmountValidationService<AccountWallet> amountValidation;

    @Transactional
    @Override
    public void validate(InternalDeposit transaction) {
        DigitalWallet destination = digitalWalletValidation.isAvailableWallet(
                transaction.getEmail(),
                transaction.getTo_digital_wallet()
        );
        AccountWallet source = accountWalletValidation.isAvailableWallet(
                transaction.getEmail(),
                transaction.getFrom_account_wallet()
        );

        currenciesValidation.validateCurrencies(destination.getCryptoCurrency(), source.getCryptoCurrency());
        amountValidation.isAmountEnough(source, transaction.getAmount());
    }
}
