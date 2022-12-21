package com.exchange.clients_management.controller;

import com.exchange.clients_management.domain.Client;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ClientVerify {

    @PutMapping(value = "/verify", params = {"email"})
    Client verify (@RequestParam String email);

    @PutMapping(value = "/unverify", params = {"email"})
    Client unverify (@RequestParam String email);

}
