package com.exchange.payment_system.service.impl;

import com.exchange.payment_system.domain.AccountWallet;
import com.exchange.payment_system.repository.AccountWalletRepository;
import com.exchange.payment_system.service.CurrencyService;
import com.exchange.payment_system.service.WalletProcessingService;
import com.exchange.payment_system.util.exceptions.AccountWalletNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountWalletProcessingServiceBean implements WalletProcessingService<AccountWallet> {

    private final AccountWalletRepository accountWalletRepository;

    private final CurrencyService currencyService;

    @Override
    public void depositConfirmed(String accountWallet, Double amount, String email) {
        accountWalletRepository.findAccountWalletByEmailAndNumber(email, accountWallet)
                .map(aw -> {
                    aw.increaseBalance(amount);
                    return accountWalletRepository.save(aw);
                })
                .orElseThrow(() -> new AccountWalletNotFoundException("Can't find account wallet with email: " + email + " and number: " + accountWallet));
    }

    @Override
    public void withdrawalConfirmed(String accountWallet, Double amount, String email) {
        accountWalletRepository.findAccountWalletByEmailAndNumber(email, accountWallet)
                .map(aw -> {
                    aw.decreaseBalance(amount);
                    return accountWalletRepository.save(aw);
                })
                .orElseThrow(() -> new AccountWalletNotFoundException("Can't find account wallet with email: " + email + " and number: " + accountWallet));
    }

    @Transactional
    @Override
    public AccountWallet addWallet(String email, Long currency_id) {
        return  accountWalletRepository.save(
                AccountWallet.builder()
                        .email(email)
                        .balance(0.0)
                        .number("")
                        .currency(currencyService.getById(currency_id))
                        .build()
        );
    }

}
