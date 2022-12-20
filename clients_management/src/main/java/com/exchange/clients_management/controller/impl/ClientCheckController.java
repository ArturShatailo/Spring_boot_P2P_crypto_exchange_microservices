package com.exchange.clients_management.controller.impl;

import com.exchange.clients_management.controller.ClientCheck;
import com.exchange.clients_management.service.ClientInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/client/c", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ClientCheckController implements ClientCheck {

    private final ClientInfoService clientInfoService;

    @Override
    @GetMapping(value = "/v", params = {"email"})
    @ResponseStatus(HttpStatus.FOUND)
    public boolean is_verified(String email) {
        return clientInfoService.is_verified(email);
    }

    @Override
    @GetMapping(value = "/b", params = {"email"})
    @ResponseStatus(HttpStatus.FOUND)
    public boolean is_blocked(String email) {
        return clientInfoService.is_blocked(email);
    }

}
