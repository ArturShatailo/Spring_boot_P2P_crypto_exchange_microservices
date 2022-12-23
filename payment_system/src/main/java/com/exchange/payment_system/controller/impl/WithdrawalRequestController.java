package com.exchange.payment_system.controller.impl;

import com.exchange.payment_system.controller.WithdrawalRequestProcessing;
import com.exchange.payment_system.domain.WithdrawalRequest;
import com.exchange.payment_system.domain.dto.WithdrawalRequestDTO;
import com.exchange.payment_system.service.WithdrawalRequestProcessingService;
import com.exchange.payment_system.util.mapper.WithdrawalRequestMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/ps/w", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class WithdrawalRequestController implements WithdrawalRequestProcessing {

    private final WithdrawalRequestProcessingService withdrawalRequestProcessingService;

    private final WithdrawalRequestMapper withdrawalRequestMapper;

    @Override
    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public WithdrawalRequest startWithdrawalRequest(@RequestBody WithdrawalRequestDTO dto) {
        return withdrawalRequestProcessingService
                .create(withdrawalRequestMapper.withdrawalRequestDTOtoObject(dto));
    }

    @Override
    @PutMapping(value = "/accept", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public void acceptWithdrawalRequest(@RequestParam Long id) {
        withdrawalRequestProcessingService.accept(id);
    }

    @Override
    @PutMapping(value = "/decline", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public void declineWithdrawalRequest(@RequestParam Long id) {
        withdrawalRequestProcessingService.decline(id);
    }

}
