package com.exchange.payment_methods_management.controller;

import com.exchange.payment_methods_management.domain.CardDetails;
import com.exchange.payment_methods_management.domain.dto.CardDetailsDTO;
import com.exchange.payment_methods_management.service.DetailsCrudService;
import com.exchange.payment_methods_management.util.mapper.CardDetailsMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/p-methods", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CardDetailsController {

    private final CardDetailsMapper cardDetailsMapper;

    private final DetailsCrudService<CardDetails, Long> cardDetailsService;

    @PostMapping(value = "/c")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCardDetails(@RequestBody CardDetailsDTO dto){
        cardDetailsService.add(cardDetailsMapper.cardDetailsDTOtoObject(dto));
    }

}
