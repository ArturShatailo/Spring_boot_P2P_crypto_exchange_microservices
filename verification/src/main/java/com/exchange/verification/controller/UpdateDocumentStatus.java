package com.exchange.verification.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface UpdateDocumentStatus {

    @PutMapping(value = "/status/{id}")
    String updateStatus(@PathVariable("id") Long id, @RequestParam("status") String status);

}
