package com.exchange.payment_methods_management.controller.impl;

import com.exchange.payment_methods_management.controller.DetailsCrudControllerMethods;
import com.exchange.payment_methods_management.domain.PayPalDetails;
import com.exchange.payment_methods_management.domain.dto.PayPalDetailsDTO;
import com.exchange.payment_methods_management.service.DetailsCrudService;
import com.exchange.payment_methods_management.util.mapper.PayPalDetailsMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/p-methods/pp", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class PayPalDetailsController implements DetailsCrudControllerMethods<PayPalDetailsDTO, PayPalDetails, Long> {

    private final PayPalDetailsMapper payPalDetailsMapper;

    private final DetailsCrudService<PayPalDetails, Long> payPalDetailsService;

    @Override
    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDetails(@RequestBody PayPalDetailsDTO dto) {
        payPalDetailsService.add(payPalDetailsMapper.payPalDetailsDTOtoObject(dto));
    }

    @Override
    @PutMapping(value = "/", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public void updateDetails(@RequestBody PayPalDetailsDTO dto, Long id) {
        payPalDetailsService.update(payPalDetailsMapper.payPalDetailsDTOtoObject(dto), id);
    }

    @Override
    @DeleteMapping(value = "/" , params = {"id", "email"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteDetails(Long id, String email) {
        payPalDetailsService.delete(id, email);
    }

    @Override
    @GetMapping(value = "/", params = {"id", "email"})
    @ResponseStatus(HttpStatus.FOUND)
    public PayPalDetails getDetails(Long id, String email) {
        return payPalDetailsService.get(id, email);
    }
}
