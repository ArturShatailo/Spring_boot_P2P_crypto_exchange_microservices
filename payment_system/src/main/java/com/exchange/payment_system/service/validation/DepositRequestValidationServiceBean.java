package com.exchange.payment_system.service.validation;

import com.exchange.payment_system.domain.transactions.DepositRequest;
import com.exchange.payment_system.domain.wallets.AccountWallet;
import com.exchange.payment_system.service.validation.validationServices.WalletValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepositRequestValidationServiceBean implements TransactionValidationService<DepositRequest>{

    private final WalletValidationService<AccountWallet> accountWalletValidation;

    @Override
    public void validate(DepositRequest transaction) {
        accountWalletValidation.isAvailableWallet(transaction.getEmail(), transaction.getWallet());
    }
}
