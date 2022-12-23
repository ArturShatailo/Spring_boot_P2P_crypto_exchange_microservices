package com.exchange.payment_system.controller.impl;

import com.exchange.payment_system.controller.DepositRequestProcessing;
import com.exchange.payment_system.domain.DepositRequest;
import com.exchange.payment_system.domain.dto.DepositRequestDTO;
import com.exchange.payment_system.service.DepositRequestProcessingService;
import com.exchange.payment_system.util.mapper.DepositRequestMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/ps/d", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class DepositRequestController implements DepositRequestProcessing {

    private final DepositRequestProcessingService depositRequestProcessingService;

    private final DepositRequestMapper depositRequestMapper;

    @Override
    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public DepositRequest startDepositRequest(@RequestBody DepositRequestDTO dto) {
        return depositRequestProcessingService
                .create(depositRequestMapper.depositRequestDTOtoObject(dto));
    }

    @Override
    @PutMapping(value = "/accept", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public void acceptDepositRequest(@RequestParam Long id) {
        depositRequestProcessingService.accept(id);
    }

    @Override
    @PutMapping(value = "/decline", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public void declineDepositRequest(@RequestParam Long id) {
        depositRequestProcessingService.decline(id);
    }

}
