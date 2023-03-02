package com.exchange.payment_system.controller.impl;

import com.exchange.payment_system.domain.wallets.AccountWallet;
import com.exchange.payment_system.service.AddWalletService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/ps/aw", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AccountWalletController {

    private final AddWalletService<AccountWallet> addWalletService;

    @PostMapping(value = "/", params = {"email", "currency_id"})
    @ResponseStatus(HttpStatus.CREATED)
    public AccountWallet addAccountWallet(@RequestParam String email, @RequestParam Long currency_id) {
        return addWalletService.addWallet(email, currency_id);
    }

}
