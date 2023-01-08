package com.exchange.payment_system.service.impl.wallets;

import com.exchange.payment_system.repository.DigitalWalletRepository;
import com.exchange.payment_system.service.DigitalWalletHoldFundsService;
import com.exchange.payment_system.util.exceptions.DigitalWalletNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DigitalWalletHoldFundsServiceBean implements DigitalWalletHoldFundsService {

    private final DigitalWalletRepository digitalWalletRepository;

    @Override
    public void p2pDigitalWalletHoldFunds(String wallet, Double amount, String email) {
        digitalWalletRepository.findDigitalWalletByEmailAndNumber(email, wallet)
                .map(dw -> {
                    dw.holdBalance(amount);
                    return digitalWalletRepository.save(dw);
                })
                .orElseThrow(() -> new DigitalWalletNotFoundException("Can't find digital wallet with email: " + email + " and number: " + wallet));
    }
}
