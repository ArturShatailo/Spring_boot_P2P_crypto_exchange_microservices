package com.exchange.payment_system.controller;

import com.exchange.payment_system.domain.dto.InternalWithdrawalDTO;
import com.exchange.payment_system.domain.transactions.InternalWithdrawal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface InternalWithdrawalProcessing {

    @PostMapping(value = "/w")
    InternalWithdrawal startInternalWithdrawal(@RequestBody InternalWithdrawalDTO dto);

    @PutMapping(value = "/w/accept", params = {"id"})
    void acceptInternalWithdrawal(@RequestParam Long id);

    @PutMapping(value = "/w/decline", params = {"id"})
    void declineInternalWithdrawal(@RequestParam Long id);
}
