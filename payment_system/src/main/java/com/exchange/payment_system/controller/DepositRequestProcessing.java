package com.exchange.payment_system.controller;

import com.exchange.payment_system.domain.transactions.DepositRequest;
import com.exchange.payment_system.domain.dto.DepositRequestDTO;
import org.springframework.web.bind.annotation.*;

public interface DepositRequestProcessing {

    @PostMapping(value = "/d")
    DepositRequest startDepositRequest(@RequestBody DepositRequestDTO dto);

    @PutMapping(value = "/d/accept", params = {"id"})
    void acceptDepositRequest(@RequestParam Long id);

    @PutMapping(value = "/d/decline", params = {"id"})
    void declineDepositRequest(@RequestParam Long id);
}
