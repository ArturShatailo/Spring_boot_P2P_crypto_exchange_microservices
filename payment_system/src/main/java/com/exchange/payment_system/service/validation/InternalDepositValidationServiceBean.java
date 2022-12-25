package com.exchange.payment_system.service.validation;

import com.exchange.payment_system.domain.wallets.AccountWallet;
import com.exchange.payment_system.domain.Currency;
import com.exchange.payment_system.domain.wallets.DigitalWallet;
import com.exchange.payment_system.domain.transactions.InternalDeposit;
import com.exchange.payment_system.repository.AccountWalletRepository;
import com.exchange.payment_system.repository.DigitalWalletRepository;
import com.exchange.payment_system.util.exceptions.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InternalDepositValidationServiceBean implements TransactionValidationService<InternalDeposit>{

    private final AccountWalletRepository accountWalletRepository;

    private final DigitalWalletRepository digitalWalletRepository;

    @Transactional
    @Override
    public void validate(InternalDeposit transaction) {
        DigitalWallet destination = validateDestination(
                transaction.getEmail(),
                transaction.getTo_digital_wallet()
        );
        AccountWallet source = validateSource(
                transaction.getEmail(),
                transaction.getFrom_account_wallet()
        );

        validateCurrencies(destination.getCurrency(), source.getCurrency());
        validateAmount(source, transaction.getAmount());
    }

    private void validateCurrencies(Currency c, Currency c1) {
        if (!c.equals(c1))
            throw new CurrenciesAreNotEqualsException("Currency: " + c.getName() + " cannot be transferred into currency: " + c1.getName());
    }

    private AccountWallet validateSource(String email, String number) {
        return accountWalletRepository.findAccountWalletByEmailAndNumber(email, number)
                .orElseThrow(() -> new AccountWalletNotFoundException("Can't find account wallet with email: " + email + " and number: " + number));
    }

    private DigitalWallet validateDestination(String email, String number) {
        return digitalWalletRepository.findDigitalWalletByEmailAndNumber(email, number)
                .orElseThrow(() -> new DigitalWalletNotFoundException("Can't find digital wallet with email: " + email + " and number: " + number));
    }

    private void validateAmount(AccountWallet source, Double amount) {
        if (source.getBalance().compareTo(amount) < 0)
            throw new NotEnoughFundsOnBalanceException("Balance of the wallet: " + source.getNumber() + "is not enough");
    }
}
