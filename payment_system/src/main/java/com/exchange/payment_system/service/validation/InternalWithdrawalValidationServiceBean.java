package com.exchange.payment_system.service.validation;

import com.exchange.payment_system.domain.transactions.InternalWithdrawal;
import com.exchange.payment_system.util.configuration.PaymentSystemConfig;
import com.exchange.payment_system.util.exceptions.ClientIsNotVerifiedException;
import com.exchange.payment_system.util.exceptions.NotEnoughFundsOnBalanceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InternalWithdrawalValidationServiceBean implements TransactionValidationService<InternalWithdrawal>{

    private final PaymentSystemConfig paymentSystemConfig;

    @Override
    public void validate(InternalWithdrawal transaction) {
        validateAmount(transaction);
        validateVerification(transaction.getEmail());
    }

    private void validateVerification(String email) {
        String uri = paymentSystemConfig.isVerifiedClient();
        boolean verification = Boolean.TRUE.equals(
                paymentSystemConfig.restTemplate().getForObject(uri, boolean.class, email)
        );
        if (!verification) throw new ClientIsNotVerifiedException("Client with email: " + email + "is not verified");
    }

    private void validateAmount(InternalWithdrawal t) {
        if (t.getFrom().getBalance_available().compareTo(t.getAmount()) < 0)
            throw new NotEnoughFundsOnBalanceException("Balance of the wallet: " + t.getFrom().getNumber() + "is not enough");
    }
}
