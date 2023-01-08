package com.exchange.market.controller;

import com.exchange.market.domain.dto.BuyAdvertDTO;
import com.exchange.market.domain.dto.BuyAdvertInfoDTO;
import com.exchange.market.service.BuyAdvertService;
import com.exchange.market.util.mapper.BuyAdvertMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/market/adverts", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AdvertController {

    private final BuyAdvertMapper buyAdvertMapper;

    private final BuyAdvertService buyAdvertService;

    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBuyAdvert(@RequestBody BuyAdvertDTO dto){
        buyAdvertService.create(buyAdvertMapper.buyAdvertDTOtoObject(dto));
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public BuyAdvertInfoDTO getInfo(@PathVariable Long id){
        return buyAdvertMapper.objectToBuyAdvertInfoDTO(buyAdvertService.getInfo(id));
    }

}
