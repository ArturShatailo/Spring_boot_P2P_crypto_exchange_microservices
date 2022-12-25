package com.exchange.payment_system.controller.impl;

import com.exchange.payment_system.controller.InternalDepositProcessing;
import com.exchange.payment_system.controller.InternalWithdrawalProcessing;
import com.exchange.payment_system.domain.dto.InternalDepositDTO;
import com.exchange.payment_system.domain.dto.InternalWithdrawalDTO;
import com.exchange.payment_system.domain.transactions.InternalDeposit;
import com.exchange.payment_system.domain.transactions.InternalWithdrawal;
import com.exchange.payment_system.service.TransactionProcessingService;
import com.exchange.payment_system.util.mapper.InternalDepositMapper;
import com.exchange.payment_system.util.mapper.InternalWithdrawalMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/ps/ipay", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class InternalTransferController implements InternalDepositProcessing, InternalWithdrawalProcessing {

    private final TransactionProcessingService<InternalDeposit> depositTransactionService;

    private final TransactionProcessingService<InternalWithdrawal> withdrawalTransactionService;

    private final InternalDepositMapper internalDepositMapper;

    private final InternalWithdrawalMapper internalWithdrawalMapper;

    @Override
    @PostMapping(value = "/d")
    @ResponseStatus(HttpStatus.CREATED)
    public InternalDeposit startInternalDeposit(InternalDepositDTO dto) {
        return depositTransactionService
                .create(internalDepositMapper.internalDepositDTOtoObject(dto));
    }

    @Override
    @PutMapping(value = "/d/accept", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public void acceptInternalDeposit(Long id) {
        depositTransactionService.accept(id);
    }

    @Override
    @PutMapping(value = "/d/decline", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public void declineInternalDeposit(Long id) {
        depositTransactionService.decline(id);
    }

    @Override
    @PostMapping(value = "/w")
    @ResponseStatus(HttpStatus.CREATED)
    public InternalWithdrawal startInternalWithdrawal(InternalWithdrawalDTO dto) {
        return withdrawalTransactionService
                .create(internalWithdrawalMapper.internalWithdrawalDTOtoObject(dto));
    }

    @Override
    @PutMapping(value = "/w/accept", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public void acceptInternalWithdrawal(Long id) {
        withdrawalTransactionService.accept(id);
    }

    @Override
    @PutMapping(value = "/w/decline", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public void declineInternalWithdrawal(Long id) {
        withdrawalTransactionService.decline(id);
    }
}
