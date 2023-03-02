package com.exchange.payment_methods_management.controller.impl;

import com.exchange.payment_methods_management.controller.CrudControllerMethods;
import com.exchange.payment_methods_management.domain.PaymentMethod;
import com.exchange.payment_methods_management.domain.dto.PaymentMethodSaveDTO;
import com.exchange.payment_methods_management.service.CrudService;
import com.exchange.payment_methods_management.util.mapper.PaymentMethodMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/p-methods/methods", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class PaymentMethodCrudController implements CrudControllerMethods<PaymentMethodSaveDTO, PaymentMethod, Long> {

    private final CrudService<PaymentMethod, Long> paymentMethodCrudService;

    private final PaymentMethodMapper paymentMethodMapper;

    @Override
    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentMethod create(@RequestBody PaymentMethodSaveDTO dto) {
        return paymentMethodCrudService.create(paymentMethodMapper.paymentMethodSaveDTOtoObject(dto));
    }

    @Override
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody PaymentMethodSaveDTO dto, @PathVariable Long id) {
        paymentMethodCrudService.update(paymentMethodMapper.paymentMethodSaveDTOtoObject(dto), id);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        paymentMethodCrudService.delete(id);
    }

    @Override
    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.FOUND)
    public List<PaymentMethod> getAll() {
        return paymentMethodCrudService.getAll();
    }

    @Override
    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public PaymentMethod get(@PathVariable Long id) {
        return paymentMethodCrudService.get(id);
    }
}
