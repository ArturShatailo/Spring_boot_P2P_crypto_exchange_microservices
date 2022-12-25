package com.exchange.payment_system.service.validation;

import com.exchange.payment_system.domain.wallets.AccountWallet;
import com.exchange.payment_system.domain.transactions.WithdrawalRequest;
import com.exchange.payment_system.repository.AccountWalletRepository;
import com.exchange.payment_system.util.configuration.PaymentSystemConfig;
import com.exchange.payment_system.util.exceptions.AccountWalletNotFoundException;
import com.exchange.payment_system.util.exceptions.ClientIsNotVerifiedException;
import com.exchange.payment_system.util.exceptions.NotEnoughFundsOnBalanceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WithdrawalRequestValidationServiceBean implements TransactionValidationService<WithdrawalRequest>{

    private final PaymentSystemConfig paymentSystemConfig;

    private final AccountWalletRepository accountWalletRepository;

    @Override
    public void validate(WithdrawalRequest transaction) {
        validateVerification(transaction.getEmail());
        AccountWallet source = validateSource(
                transaction.getEmail(),
                transaction.getWallet()
        );
        validateAmount(source, transaction.getAmount());
    }

    private AccountWallet validateSource(String email, String number) {
        return accountWalletRepository.findAccountWalletByEmailAndNumber(email, number)
                .orElseThrow(() -> new AccountWalletNotFoundException("Can't find account wallet with number: " + number));
    }

    private void validateVerification(String email) {
        String uri = paymentSystemConfig.isVerifiedClient();
        boolean verification = Boolean.TRUE.equals(
                paymentSystemConfig.restTemplate().getForObject(uri, boolean.class, email)
        );
        if (!verification) throw new ClientIsNotVerifiedException("Client with email: " + email + "is not verified");
    }

    private void validateAmount(AccountWallet wallet, Double amount) {
        if (wallet.getBalance().compareTo(amount) < 0)
            throw new NotEnoughFundsOnBalanceException("Balance of the wallet: " + wallet.getNumber() + " is not enough");
    }
}
