package com.exchange.payment_system.service.impl.wallets;

import com.exchange.payment_system.domain.CryptoCurrency;
import com.exchange.payment_system.domain.wallets.AccountWallet;
import com.exchange.payment_system.repository.AccountWalletRepository;
import com.exchange.payment_system.service.AddWalletService;
import com.exchange.payment_system.service.CurrencyService;
import com.exchange.payment_system.service.WalletTransfersProcessingService;
import com.exchange.payment_system.util.exceptions.AccountWalletExistsException;
import com.exchange.payment_system.util.exceptions.AccountWalletNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountWalletTransfersProcessingServiceBean implements WalletTransfersProcessingService<AccountWallet>, AddWalletService<AccountWallet> {

    private final AccountWalletRepository accountWalletRepository;

    private final CurrencyService<CryptoCurrency> currencyService;

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

        accountWalletRepository.findAccountWalletByEmailAndCryptoCurrencyId(email, currency_id)
                .ifPresent(accountWallet -> {
                    throw new AccountWalletExistsException(accountWallet.getCryptoCurrency().getName() + " account wallet with email: " + email + " exists");
                });
        return  accountWalletRepository.save(
                AccountWallet.builder()
                        .email(email)
                        .balance(0.0)
                        .number("")
                        .cryptoCurrency(currencyService.getById(currency_id))
                        .build()
        );
    }

}
