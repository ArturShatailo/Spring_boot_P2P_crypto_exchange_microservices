package com.exchange.market.controller;

import com.exchange.market.domain.dto.BuyOrderDTO;
import com.exchange.market.service.BuyOrderService;
import com.exchange.market.util.mapper.BuyOrderMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/market/orders", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class OrderController {

    private final BuyOrderService buyOrderService;

    private final BuyOrderMapper buyOrderMapper;

    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBuyOrder(@RequestBody BuyOrderDTO dto){
        buyOrderService.create(buyOrderMapper.buyOrderDTOtoObject(dto));
    }

}
