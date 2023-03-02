package com.exchange.payment_system.controller.impl;

import com.exchange.payment_system.domain.wallets.DigitalWallet;
import com.exchange.payment_system.service.AddWalletService;
import com.exchange.payment_system.service.DigitalWalletHoldFundsService;
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

    private final AddWalletService<DigitalWallet> addWalletService;

    private final DigitalWalletHoldFundsService holdFundsService;

    @PostMapping(value = "/", params = {"email", "currency_id"})
    @ResponseStatus(HttpStatus.CREATED)
    public DigitalWallet addDigitalWallet(@RequestParam String email, @RequestParam Long currency_id) {
        return addWalletService.addWallet(email, currency_id);
    }

    @PutMapping(value = "/", params = {"email", "amount", "wallet"})
    @ResponseStatus(HttpStatus.OK)
    public void digitalWalletHoldFunds(@RequestParam String email, @RequestParam Double amount, @RequestParam String wallet) {
        holdFundsService.p2pDigitalWalletHoldFunds(email, amount, wallet);
    }

}
