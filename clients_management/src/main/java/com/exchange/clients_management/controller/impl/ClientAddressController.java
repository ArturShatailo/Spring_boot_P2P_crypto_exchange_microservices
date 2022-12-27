package com.exchange.clients_management.controller.impl;

import com.exchange.clients_management.controller.ClientAddress;
import com.exchange.clients_management.domain.dto.AddressDTO;
import com.exchange.clients_management.service.ClientAddressService;
import com.exchange.clients_management.util.mapper.AddressMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/client", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ClientAddressController implements ClientAddress {

    private final ClientAddressService clientAddressService;

    private final AddressMapper addressMapper;

    @Override
    @PutMapping(value = "/address")
    @ResponseStatus(HttpStatus.OK)
    public void saveAddress(@RequestBody AddressDTO dto){
        clientAddressService.add(addressMapper.addressDTOtoObject(dto));
    }

}
