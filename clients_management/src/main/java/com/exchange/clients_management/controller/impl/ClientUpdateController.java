package com.exchange.clients_management.controller.impl;

import com.exchange.clients_management.controller.ClientBlock;
import com.exchange.clients_management.controller.ClientVerify;
import com.exchange.clients_management.domain.Client;
import com.exchange.clients_management.service.ClientUpdateStatusService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/client", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ClientUpdateController implements ClientBlock, ClientVerify {

    private final ClientUpdateStatusService clientUpdateStatusService;

    @Override
    @PutMapping(value = "/block", params = {"email"})
    @ResponseStatus(HttpStatus.CREATED)
    public Client block(String email) {
        return clientUpdateStatusService.block(email);
    }

    @Override
    @PutMapping(value = "/unblock", params = {"email"})
    @ResponseStatus(HttpStatus.CREATED)
    public Client unblock(String email) {
        return clientUpdateStatusService.unblock(email);
    }

    @Override
    @PutMapping(value = "/verify", params = {"email"})
    @ResponseStatus(HttpStatus.OK)
    public Client verify(String email) {
        return clientUpdateStatusService.verify(email);
    }

    @Override
    @PutMapping(value = "/unverify", params = {"email"})
    @ResponseStatus(HttpStatus.OK)
    public Client unverify(String email) {
        return clientUpdateStatusService.unverify(email);
    }
}
