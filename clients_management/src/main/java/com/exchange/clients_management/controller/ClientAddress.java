package com.exchange.clients_management.controller;

import com.exchange.clients_management.domain.dto.AddressDTO;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClientAddress {

    @PutMapping(value = "/address")
    void saveAddress(@RequestBody AddressDTO dto);

}
