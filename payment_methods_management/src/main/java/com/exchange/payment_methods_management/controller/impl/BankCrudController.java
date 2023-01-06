package com.exchange.payment_methods_management.controller.impl;

import com.exchange.payment_methods_management.controller.CrudControllerMethods;
import com.exchange.payment_methods_management.domain.Bank;
import com.exchange.payment_methods_management.domain.dto.BankSaveDTO;
import com.exchange.payment_methods_management.service.CrudService;
import com.exchange.payment_methods_management.util.mapper.BankMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/p-methods/banks", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class BankCrudController implements CrudControllerMethods<BankSaveDTO, Bank, Long> {

    private final CrudService<Bank, Long> bankCrudService;

    private final BankMapper bankMapper;

    @Override
    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public Bank create(@RequestBody BankSaveDTO dto) {
        return bankCrudService.create(bankMapper.bankSaveDTOtoObject(dto));
    }

    @Override
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody BankSaveDTO dto, @PathVariable Long id) {
        bankCrudService.update(bankMapper.bankSaveDTOtoObject(dto), id);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        bankCrudService.delete(id);
    }

    @Override
    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Bank> getAll() {
        return bankCrudService.getAll();
    }

    @Override
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Bank get(@PathVariable Long id) {
        return bankCrudService.get(id);
    }
}
