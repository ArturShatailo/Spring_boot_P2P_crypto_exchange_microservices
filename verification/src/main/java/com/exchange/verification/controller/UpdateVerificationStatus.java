package com.exchange.verification.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

public interface UpdateVerificationStatus {

    @PutMapping(value = "/status/{id}")
    String updateStatus(@PathVariable("id") Long id);

}
