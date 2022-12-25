package com.exchange.payment_system.service.validation;

import com.exchange.payment_system.domain.transactions.DepositRequest;
import com.exchange.payment_system.repository.AccountWalletRepository;
import com.exchange.payment_system.util.exceptions.AccountWalletNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepositRequestValidationServiceBean implements TransactionValidationService<DepositRequest>{

    private final AccountWalletRepository accountWalletRepository;

    @Override
    public void validate(DepositRequest transaction) {
        validateDestination(transaction.getEmail(), transaction.getWallet());
    }

    private void validateDestination(String email, String number) {
        accountWalletRepository.findAccountWalletByEmailAndNumber(email, number)
                .orElseThrow(() -> new AccountWalletNotFoundException("Can't find account wallet with number: " + number));
    }
}
