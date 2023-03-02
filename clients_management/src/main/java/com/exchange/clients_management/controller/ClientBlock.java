package com.exchange.clients_management.controller;

import com.exchange.clients_management.domain.Client;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ClientBlock {

    @PutMapping(value = "/block", params = {"id"})
    Client block (@RequestParam Long id);

    @PutMapping(value = "/unblock", params = {"id"})
    Client unblock (@RequestParam Long id);

}
