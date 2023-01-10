package com.exchange.payment_system.service.validation.validationServices;

import com.exchange.payment_system.domain.wallets.AccountWallet;
import com.exchange.payment_system.repository.AccountWalletRepository;
import com.exchange.payment_system.util.exceptions.AccountWalletNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountWalletValidationServiceBean implements WalletValidationService<AccountWallet> {

    private final AccountWalletRepository accountWalletRepository;

    @Override
    public AccountWallet isAvailableWallet(String email, String number) {
        return accountWalletRepository.findAccountWalletByEmailAndNumber(email, number)
                .orElseThrow(() -> new AccountWalletNotFoundException("Can't find account wallet with number: " + number));

    }
}
