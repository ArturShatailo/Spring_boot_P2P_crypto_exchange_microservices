package com.exchange.payment_system.service.validation;

import com.exchange.payment_system.domain.CryptoCurrency;
import com.exchange.payment_system.domain.transactions.P2PTransaction;
import com.exchange.payment_system.domain.wallets.DigitalWallet;
import com.exchange.payment_system.service.validation.validationServices.ClientValidationService;
import com.exchange.payment_system.service.validation.validationServices.CurrenciesValidation;
import com.exchange.payment_system.service.validation.validationServices.WalletValidationService;
import com.exchange.payment_system.util.exceptions.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class P2PTransactionValidationServiceBean implements TransactionValidationService<P2PTransaction> {

    private final ClientValidationService clientValidation;

    private final CurrenciesValidation<CryptoCurrency> currenciesValidation;

    private final WalletValidationService<DigitalWallet> digitalWalletValidation;

    @Override
    public void validate(P2PTransaction transaction) {
        clientValidation.validateVerification(transaction.getEmail_from());
        clientValidation.validateVerification(transaction.getEmail_to());

        DigitalWallet destination = digitalWalletValidation.isAvailableWallet(
                transaction.getEmail_to(),
                transaction.getTo_wallet()
        );
        DigitalWallet source = digitalWalletValidation.isAvailableWallet(
                transaction.getEmail_from(),
                transaction.getFrom_wallet()
        );

        currenciesValidation.validateCurrencies(destination.getCryptoCurrency(), source.getCryptoCurrency());
        validateAmount(source, transaction.getAmount());
    }

    private void validateAmount(DigitalWallet source, Double amount) {
        if (source.getBalance_held().compareTo(amount) < 0)
            throw new NotEnoughFundsOnBalanceException("Balance of the wallet: " + source.getNumber() + "is not enough");
    }
}
