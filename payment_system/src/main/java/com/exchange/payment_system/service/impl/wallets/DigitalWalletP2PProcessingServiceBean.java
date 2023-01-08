package com.exchange.payment_system.service.impl.wallets;

import com.exchange.payment_system.repository.DigitalWalletRepository;
import com.exchange.payment_system.service.WalletP2PProcessingService;
import com.exchange.payment_system.util.exceptions.DigitalWalletNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DigitalWalletP2PProcessingServiceBean implements WalletP2PProcessingService {

    private final DigitalWalletRepository digitalWalletRepository;

    @Override
    public void p2pDepositConfirmed(String wallet, Double amount, String email) {
        digitalWalletRepository.findDigitalWalletByEmailAndNumber(email, wallet)
                .map(dw -> {
                    dw.increaseBalance(amount);
                    return digitalWalletRepository.save(dw);
                })
                .orElseThrow(() -> new DigitalWalletNotFoundException("Can't find digital wallet with email: " + email + " and number: " + wallet));
    }

    @Override
    public void p2pWithdrawalConfirmed(String wallet, Double amount, String email) {
        digitalWalletRepository.findDigitalWalletByEmailAndNumber(email, wallet)
                .map(dw -> {
                    dw.p2pTransferBalance(amount);
                    return digitalWalletRepository.save(dw);
                })
                .orElseThrow(() -> new DigitalWalletNotFoundException("Can't find digital wallet with email: " + email + " and number: " + wallet));
    }

}
