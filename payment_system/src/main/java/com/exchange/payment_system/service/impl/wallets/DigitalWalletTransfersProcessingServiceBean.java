package com.exchange.payment_system.service.impl.wallets;

import com.exchange.payment_system.domain.CryptoCurrency;
import com.exchange.payment_system.domain.wallets.DigitalWallet;
import com.exchange.payment_system.repository.DigitalWalletRepository;
import com.exchange.payment_system.service.AddWalletService;
import com.exchange.payment_system.service.CurrencyService;
import com.exchange.payment_system.service.WalletTransfersProcessingService;
import com.exchange.payment_system.util.exceptions.AccountWalletNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DigitalWalletTransfersProcessingServiceBean implements WalletTransfersProcessingService<DigitalWallet>, AddWalletService<DigitalWallet> {

    private final DigitalWalletRepository digitalWalletRepository;

    private final CurrencyService<CryptoCurrency> currencyService;

    @Override
    public void depositConfirmed(String wallet, Double amount, String email) {
        digitalWalletRepository.findDigitalWalletByEmailAndNumber(email, wallet)
                .map(dw -> {
                    dw.increaseBalance(amount);
                    return digitalWalletRepository.save(dw);
                })
                .orElseThrow(() -> new AccountWalletNotFoundException("Can't find digital wallet with email: " + email + " and number: " + wallet));
    }

    @Override
    public void withdrawalConfirmed(String wallet, Double amount, String email) {
        digitalWalletRepository.findDigitalWalletByEmailAndNumber(email, wallet)
                .map(dw -> {
                    dw.decreaseBalance(amount);
                    return digitalWalletRepository.save(dw);
                })
                .orElseThrow(() -> new AccountWalletNotFoundException("Can't find digital wallet with email: " + email + " and number: " + wallet));
    }

    @Transactional
    @Override
    public DigitalWallet addWallet(String email, Long currency_id) {
        return  digitalWalletRepository.save(
                DigitalWallet.builder()
                        .email(email)
                        .balance(0.0)
                        .balance_held(0.0)
                        .balance_available(0.0)
                        .number("")
                        .cryptoCurrency(currencyService.getById(currency_id))
                        .build()
        );
    }

}
