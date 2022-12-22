package com.exchange.verification.controller.impl;

import com.exchange.verification.controller.UpdateVerificationStatus;
import com.exchange.verification.controller.VerificationRegistration;
import com.exchange.verification.service.VerificationRegistrationService;
import com.exchange.verification.service.VerificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/verification")
@AllArgsConstructor
public class VerificationController implements VerificationRegistration, UpdateVerificationStatus {

    private final VerificationRegistrationService verificationRegistrationService;

    private final VerificationService verificationService;

    @Override
    @PostMapping(value = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void newVerification(@RequestParam("email") String email) {
        verificationRegistrationService.newVerification(email);
    }

    @Override
    @PutMapping(value = "/status/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateStatus(@PathVariable("id") Long id) {
        return verificationService.updateStatus(id);
    }

}
