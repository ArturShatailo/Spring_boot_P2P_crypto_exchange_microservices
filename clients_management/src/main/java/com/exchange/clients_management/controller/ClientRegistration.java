package com.exchange.clients_management.controller;

import com.exchange.clients_management.domain.Client;
import com.exchange.clients_management.domain.dto.ClientRegisterDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClientRegistration {

    @PostMapping("/")
    Client register (@RequestBody ClientRegisterDTO dto);

}
