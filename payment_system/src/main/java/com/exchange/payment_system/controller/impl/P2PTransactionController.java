package com.exchange.payment_system.controller.impl;

import com.exchange.payment_system.controller.P2PTransactionProcessing;
import com.exchange.payment_system.domain.dto.P2PTransactionDTO;
import com.exchange.payment_system.domain.transactions.P2PTransaction;
import com.exchange.payment_system.service.TransactionProcessingService;
import com.exchange.payment_system.util.mapper.P2PTransactionMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/ps/p2p", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class P2PTransactionController implements P2PTransactionProcessing {

    private final TransactionProcessingService<P2PTransaction> p2pTransactionService;

    private final P2PTransactionMapper p2pTransactionMapper;

    @Override
    @PostMapping(value = "/tr")
    @ResponseStatus(HttpStatus.CREATED)
    public P2PTransaction startP2PTransaction(@RequestBody P2PTransactionDTO dto) {
        return p2pTransactionService
                .create(p2pTransactionMapper.p2pTransactionDTOtoObject(dto));
    }

    @Override
    @PutMapping(value = "/tr/accept", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public void acceptP2PTransaction(@RequestParam Long id) {
        p2pTransactionService.accept(id);
    }

    @Override
    @PutMapping(value = "/tr/decline", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public void declineP2PTransaction(@RequestParam Long id) {
        p2pTransactionService.decline(id);
    }
}
