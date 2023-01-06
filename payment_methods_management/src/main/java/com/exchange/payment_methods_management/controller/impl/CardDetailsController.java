package com.exchange.payment_methods_management.controller.impl;

import com.exchange.payment_methods_management.controller.DetailsCrudControllerMethods;
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
@RequestMapping(value = "/api/p-methods/c", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CardDetailsController implements DetailsCrudControllerMethods<CardDetailsDTO, CardDetails, Long> {

    private final CardDetailsMapper cardDetailsMapper;

    private final DetailsCrudService<CardDetails, Long> cardDetailsService;

    @Override
    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDetails(@RequestBody CardDetailsDTO dto){
        cardDetailsService.add(cardDetailsMapper.cardDetailsDTOtoObject(dto));
    }

    @Override
    @PutMapping(value = "/", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public void updateDetails(@RequestBody CardDetailsDTO dto, @RequestParam Long id) {
        cardDetailsService.update(cardDetailsMapper.cardDetailsDTOtoObject(dto), id);
    }

    @Override
    @DeleteMapping(value = "/" , params = {"id", "email"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteDetails(@RequestParam Long id, @RequestParam String email) {
        cardDetailsService.delete(id, email);
    }

    @Override
    @GetMapping(value = "/", params = {"id", "email"})
    @ResponseStatus(HttpStatus.FOUND)
    public CardDetails getDetails(@RequestParam Long id, @RequestParam String email) {
        return cardDetailsService.get(id, email);
    }


}
