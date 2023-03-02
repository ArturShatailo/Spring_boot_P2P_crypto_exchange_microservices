package com.exchange.payment_system.controller.impl;

import com.exchange.payment_system.controller.DepositRequestProcessing;
import com.exchange.payment_system.controller.WithdrawalRequestProcessing;
import com.exchange.payment_system.domain.dto.WithdrawalRequestDTO;
import com.exchange.payment_system.domain.transactions.DepositRequest;
import com.exchange.payment_system.domain.dto.DepositRequestDTO;
import com.exchange.payment_system.domain.transactions.WithdrawalRequest;
import com.exchange.payment_system.service.TransactionProcessingService;
import com.exchange.payment_system.util.mapper.DepositRequestMapper;
import com.exchange.payment_system.util.mapper.WithdrawalRequestMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/ps", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TransactionController implements DepositRequestProcessing, WithdrawalRequestProcessing {

    private final TransactionProcessingService<DepositRequest> depositTransactionService;

    private final TransactionProcessingService<WithdrawalRequest> withdrawalTransactionService;

    private final DepositRequestMapper depositRequestMapper;

    private final WithdrawalRequestMapper withdrawalRequestMapper;

    @Override
    @PostMapping(value = "/w")
    @ResponseStatus(HttpStatus.CREATED)
    public WithdrawalRequest startWithdrawalRequest(@RequestBody WithdrawalRequestDTO dto) {
        return withdrawalTransactionService
                .create(withdrawalRequestMapper.withdrawalRequestDTOtoObject(dto));
    }

    @Override
    @PutMapping(value = "/w/accept", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public void acceptWithdrawalRequest(@RequestParam Long id) {
        withdrawalTransactionService.accept(id);
    }

    @Override
    @PutMapping(value = "/w/decline", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public void declineWithdrawalRequest(@RequestParam Long id) {
        withdrawalTransactionService.decline(id);
    }

    @Override
    @PostMapping(value = "/d")
    @ResponseStatus(HttpStatus.CREATED)
    public DepositRequest startDepositRequest(@RequestBody DepositRequestDTO dto) {
        return depositTransactionService
                .create(depositRequestMapper.depositRequestDTOtoObject(dto));
    }

    @Override
    @PutMapping(value = "/d/accept", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public void acceptDepositRequest(@RequestParam Long id) {
        depositTransactionService.accept(id);
    }

    @Override
    @PutMapping(value = "/d/decline", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public void declineDepositRequest(@RequestParam Long id) {
        depositTransactionService.decline(id);
    }



}
