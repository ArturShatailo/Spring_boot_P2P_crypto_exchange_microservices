package com.exchange.payment_system.controller;

import com.exchange.payment_system.domain.WithdrawalRequest;
import com.exchange.payment_system.domain.dto.WithdrawalRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface WithdrawalRequestProcessing {

    @PostMapping(value = "/d")
    WithdrawalRequest startWithdrawalRequest(@RequestBody WithdrawalRequestDTO dto);

    @PutMapping(value = "/d/accept", params = {"id"})
    void acceptWithdrawalRequest(@RequestParam Long id);

    @PutMapping(value = "/d/decline", params = {"id"})
    void declineWithdrawalRequest(@RequestParam Long id);
}
