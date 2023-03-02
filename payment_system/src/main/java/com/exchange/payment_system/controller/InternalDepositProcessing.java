package com.exchange.payment_system.controller;

import com.exchange.payment_system.domain.dto.InternalDepositDTO;
import com.exchange.payment_system.domain.transactions.InternalDeposit;
import org.springframework.web.bind.annotation.*;

public interface InternalDepositProcessing {

    @PostMapping(value = "/d")
    InternalDeposit startInternalDeposit(@RequestBody InternalDepositDTO dto);

    @PutMapping(value = "/d/accept", params = {"id"})
    void acceptInternalDeposit(@RequestParam Long id);

    @PutMapping(value = "/d/decline", params = {"id"})
    void declineInternalDeposit(@RequestParam Long id);
}
