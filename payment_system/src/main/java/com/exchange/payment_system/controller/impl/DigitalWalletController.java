package com.exchange.payment_system.controller.impl;

import com.exchange.payment_system.domain.DigitalWallet;
import com.exchange.payment_system.service.WalletProcessingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/ps/dw", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class DigitalWalletController {

    private final WalletProcessingService<DigitalWallet> walletProcessingService;

    @PostMapping(value = "/", params = {"email", "currency_id"})
    @ResponseStatus(HttpStatus.CREATED)
    public DigitalWallet addDigitalWallet(@RequestParam String email, @RequestParam Long currency_id) {
        return walletProcessingService
                .addWallet(email, currency_id);
    }

}
