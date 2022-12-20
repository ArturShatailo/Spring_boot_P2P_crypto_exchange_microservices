package com.exchange.clients_management.controller;

import com.exchange.clients_management.domain.Client;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ClientBlock {

    @PutMapping(value = "/block", params = {"email"})
    Client block (@RequestParam String email);

    @PutMapping(value = "/unblock", params = {"email"})
    Client unblock (@RequestParam String email);

}
