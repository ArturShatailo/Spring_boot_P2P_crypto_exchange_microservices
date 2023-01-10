package com.exchange.payment_system.service.validation;

import com.exchange.payment_system.domain.CryptoCurrency;
import com.exchange.payment_system.domain.transactions.P2PTransaction;
import com.exchange.payment_system.domain.wallets.DigitalWallet;
import com.exchange.payment_system.repository.DigitalWalletRepository;
import com.exchange.payment_system.util.configuration.PaymentSystemConfig;
import com.exchange.payment_system.util.exceptions.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class P2PTransactionValidationServiceBean implements TransactionValidationService<P2PTransaction>{

    private final DigitalWalletRepository digitalWalletRepository;

    private final PaymentSystemConfig paymentSystemConfig;

    @Override
    public void validate(P2PTransaction transaction) {
        validateVerification(transaction.getEmail_from());
        validateVerification(transaction.getEmail_to());

        DigitalWallet destination = validateDestination(
                transaction.getEmail_to(),
                transaction.getTo_wallet()
        );
        DigitalWallet source = validateSource(
                transaction.getEmail_from(),
                transaction.getFrom_wallet()
        );

        validateCurrencies(destination.getCryptoCurrency(), source.getCryptoCurrency());
        validateAmount(source, transaction.getAmount());
    }

    private void validateCurrencies(CryptoCurrency c, CryptoCurrency c1) {
        if (!c.equals(c1))
            throw new CurrenciesAreNotEqualsException("Cryptocurrency: " + c.getName() + " cannot be transferred into cryptocurrency: " + c1.getName());
    }

    private DigitalWallet validateSource(String email, String number) {
        return digitalWalletRepository.findDigitalWalletByEmailAndNumber(email, number)
                .orElseThrow(() -> new DigitalWalletNotFoundException("Can't find digital wallet with email: " + email + " and number: " + number));
    }

    private DigitalWallet validateDestination(String email, String number) {
        return digitalWalletRepository.findDigitalWalletByEmailAndNumber(email, number)
                .orElseThrow(() -> new AccountWalletNotFoundException("Can't find digital wallet with email: " + email + " and number: " + number));
    }

    private void validateAmount(DigitalWallet source, Double amount) {
        if (source.getBalance_held().compareTo(amount) < 0)
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
