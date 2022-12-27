package com.exchange.clients_management.controller;

import com.exchange.clients_management.domain.Address;
import com.exchange.clients_management.domain.dto.AddressDTO;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ClientAddress {

    @PutMapping(value = "/address")
    Address saveAddress(@RequestBody AddressDTO dto, @RequestParam Long id);

}
