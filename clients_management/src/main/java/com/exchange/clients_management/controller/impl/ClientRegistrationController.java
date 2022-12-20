package com.exchange.clients_management.controller.impl;

import com.exchange.clients_management.controller.ClientRegistration;
import com.exchange.clients_management.domain.Client;
import com.exchange.clients_management.domain.dto.ClientRegisterDTO;
import com.exchange.clients_management.service.ClientRegisterService;
import com.exchange.clients_management.util.mapper.ClientMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/client", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ClientRegistrationController implements ClientRegistration {

    private final ClientMapper clientMapper;

    private final ClientRegisterService clientRegisterService;

    @Override
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Client register(ClientRegisterDTO dto) {
        return clientRegisterService.register(clientMapper.registerDTOtoObject(dto));
    }
}
