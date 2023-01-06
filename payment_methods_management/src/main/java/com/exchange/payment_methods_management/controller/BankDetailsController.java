package com.exchange.payment_methods_management.controller;

import com.exchange.payment_methods_management.domain.BankDetails;
import com.exchange.payment_methods_management.domain.dto.BankDetailsDTO;
import com.exchange.payment_methods_management.service.DetailsCrudService;
import com.exchange.payment_methods_management.util.mapper.BankDetailsMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/p-methods/b", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class BankDetailsController implements DetailsCrudControllerMethods<BankDetailsDTO, BankDetails, Long> {

    private final BankDetailsMapper bankDetailsMapper;

    private final DetailsCrudService<BankDetails, Long> bankDetailsService;

    @Override
    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDetails(@RequestBody BankDetailsDTO dto) {
        bankDetailsService.add(bankDetailsMapper.bankDetailsDTOtoObject(dto));
    }

    @Override
    @PutMapping(value = "/", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public void updateDetails(@RequestBody BankDetailsDTO dto, Long id) {
        bankDetailsService.update(bankDetailsMapper.bankDetailsDTOtoObject(dto), id);
    }

    @Override
    @DeleteMapping(value = "/" , params = {"id", "email"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteDetails(Long id, String email) {
        bankDetailsService.delete(id, email);
    }

    @Override
    @GetMapping(value = "/", params = {"id", "email"})
    @ResponseStatus(HttpStatus.FOUND)
    public BankDetails getDetails(Long id, String email) {
        return bankDetailsService.get(id, email);
    }
}
