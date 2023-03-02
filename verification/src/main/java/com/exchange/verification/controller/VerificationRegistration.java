package com.exchange.verification.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface VerificationRegistration {

    @PostMapping(value = "/new")
    void newVerification(@RequestParam("email") String email);
}
