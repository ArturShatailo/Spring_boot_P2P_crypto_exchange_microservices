package com.exchange.payment_system.service.validation;

import com.exchange.payment_system.domain.wallets.AccountWallet;
import com.exchange.payment_system.domain.transactions.WithdrawalRequest;
import com.exchange.payment_system.service.validation.validationServices.AmountValidationService;
import com.exchange.payment_system.service.validation.validationServices.ClientValidationService;
import com.exchange.payment_system.service.validation.validationServices.WalletValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WithdrawalRequestValidationServiceBean implements TransactionValidationService<WithdrawalRequest>{

    private final ClientValidationService clientValidation;

    private final WalletValidationService<AccountWallet> accountWalletValidation;

    private final AmountValidationService<AccountWallet> amountValidation;

    @Override
    public void validate(WithdrawalRequest transaction) {
        clientValidation.validateVerification(transaction.getEmail());
        AccountWallet source = accountWalletValidation.isAvailableWallet(
                transaction.getEmail(),
                transaction.getWallet()
        );
        amountValidation.isAmountEnough(source, transaction.getAmount());
    }
}
