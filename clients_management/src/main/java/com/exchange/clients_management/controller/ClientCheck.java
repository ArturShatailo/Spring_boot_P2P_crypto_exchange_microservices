package com.exchange.clients_management.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ClientCheck {

    @PostMapping(value = "/v", params = {"email"})
    boolean is_verified (@RequestParam String email);

    @PostMapping(value = "/b", params = {"email"})
    boolean is_blocked (@RequestParam String email);

}
