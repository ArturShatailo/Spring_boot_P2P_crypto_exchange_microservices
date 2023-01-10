package com.exchange.payment_system.service.validation.validationServices;

import com.exchange.payment_system.domain.wallets.DigitalWallet;
import com.exchange.payment_system.repository.DigitalWalletRepository;
import com.exchange.payment_system.util.exceptions.AccountWalletNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DigitalWalletValidationServiceBean implements WalletValidationService<DigitalWallet> {

    private final DigitalWalletRepository digitalWalletRepository;

    @Override
    public DigitalWallet isAvailableWallet(String email, String number) {
        return digitalWalletRepository.findDigitalWalletByEmailAndNumber(email, number)
                .orElseThrow(() -> new AccountWalletNotFoundException("Can't find digital wallet with number: " + number));
    }
}
