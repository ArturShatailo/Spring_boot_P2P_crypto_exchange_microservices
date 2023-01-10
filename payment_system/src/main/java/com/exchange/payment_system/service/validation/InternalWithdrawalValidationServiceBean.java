package com.exchange.payment_system.service.validation;

import com.exchange.payment_system.domain.wallets.AccountWallet;
import com.exchange.payment_system.domain.CryptoCurrency;
import com.exchange.payment_system.domain.wallets.DigitalWallet;
import com.exchange.payment_system.domain.transactions.InternalWithdrawal;
import com.exchange.payment_system.service.validation.validationServices.AmountValidationService;
import com.exchange.payment_system.service.validation.validationServices.ClientValidationService;
import com.exchange.payment_system.service.validation.validationServices.CurrenciesValidation;
import com.exchange.payment_system.service.validation.validationServices.WalletValidationService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InternalWithdrawalValidationServiceBean implements TransactionValidationService<InternalWithdrawal>{

    private final ClientValidationService clientValidation;

    private final CurrenciesValidation<CryptoCurrency> currenciesValidation;

    private final WalletValidationService<DigitalWallet> digitalWalletValidation;

    private final WalletValidationService<AccountWallet> accountWalletValidation;

    private final AmountValidationService<DigitalWallet> amountValidation;

    @Transactional
    @Override
    public void validate(InternalWithdrawal transaction) {
        clientValidation.validateVerification(transaction.getEmail());

        AccountWallet destination = accountWalletValidation.isAvailableWallet(
                transaction.getEmail(),
                transaction.getTo_account_wallet()
        );
        DigitalWallet source = digitalWalletValidation.isAvailableWallet(
                transaction.getEmail(),
                transaction.getFrom_digital_wallet()
        );

        currenciesValidation.validateCurrencies(destination.getCryptoCurrency(), source.getCryptoCurrency());
        amountValidation.isAmountEnough(source, transaction.getAmount());
    }
}
