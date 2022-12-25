package com.exchange.payment_system.service.validation;

import com.exchange.payment_system.domain.AccountWallet;
import com.exchange.payment_system.domain.Currency;
import com.exchange.payment_system.domain.DigitalWallet;
import com.exchange.payment_system.domain.transactions.InternalWithdrawal;
import com.exchange.payment_system.repository.AccountWalletRepository;
import com.exchange.payment_system.repository.DigitalWalletRepository;
import com.exchange.payment_system.util.configuration.PaymentSystemConfig;
import com.exchange.payment_system.util.exceptions.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InternalWithdrawalValidationServiceBean implements TransactionValidationService<InternalWithdrawal>{

    private final PaymentSystemConfig paymentSystemConfig;

    private final AccountWalletRepository accountWalletRepository;

    private final DigitalWalletRepository digitalWalletRepository;

    @Transactional
    @Override
    public void validate(InternalWithdrawal transaction) {
        validateVerification(transaction.getEmail());

        AccountWallet destination = validateDestination(
                transaction.getEmail(),
                transaction.getTo_account_wallet()
        );
        DigitalWallet source = validateSource(
                transaction.getEmail(),
                transaction.getFrom_digital_wallet()
        );

        validateCurrencies(destination.getCurrency(), source.getCurrency());
        validateAmount(source, transaction.getAmount());
    }

    private void validateCurrencies(Currency c, Currency c1) {
        if (!c.equals(c1))
            throw new CurrenciesAreNotEqualsException("Currency: " + c.getName() + " cannot be transferred into currency: " + c1.getName());
    }

    private DigitalWallet validateSource(String email, String number) {
        return digitalWalletRepository.findDigitalWalletByEmailAndNumber(email, number)
                .orElseThrow(() -> new DigitalWalletNotFoundException("Can't find digital wallet with email: " + email + " and number: " + number));
    }

    private AccountWallet validateDestination(String email, String number) {
        return accountWalletRepository.findAccountWalletByEmailAndNumber(email, number)
                .orElseThrow(() -> new AccountWalletNotFoundException("Can't find account wallet with email: " + email + " and number: " + number));
    }

    private void validateAmount(DigitalWallet source, Double amount) {
        if (source.getBalance_available().compareTo(amount) < 0)
            throw new NotEnoughFundsOnBalanceException("Balance of the wallet: " + source.getNumber() + "is not enough");
    }

    private void validateVerification(String email) {
        String uri = paymentSystemConfig.isVerifiedClient();
        boolean verification = Boolean.TRUE.equals(
                paymentSystemConfig.restTemplate().getForObject(uri, boolean.class, email)
        );
        if (!verification) throw new ClientIsNotVerifiedException("Client with email: " + email + "is not verified");
    }

}
