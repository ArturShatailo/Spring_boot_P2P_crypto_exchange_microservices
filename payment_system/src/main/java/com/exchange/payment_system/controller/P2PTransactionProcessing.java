package com.exchange.payment_system.controller;

import com.exchange.payment_system.domain.dto.P2PTransactionDTO;
import com.exchange.payment_system.domain.transactions.P2PTransaction;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface P2PTransactionProcessing {

    @PostMapping(value = "/tr")
    P2PTransaction startP2PTransaction(@RequestBody P2PTransactionDTO dto);

    @PutMapping(value = "/tr/accept", params = {"id"})
    void acceptP2PTransaction(@RequestParam Long id);

    @PutMapping(value = "/tr/decline", params = {"id"})
    void declineP2PTransaction(@RequestParam Long id);
}
