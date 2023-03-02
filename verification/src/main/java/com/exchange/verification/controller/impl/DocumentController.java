package com.exchange.verification.controller.impl;

import com.exchange.verification.controller.UpdateDocumentStatus;
import com.exchange.verification.service.DocumentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/verification/doc")
@AllArgsConstructor
public class DocumentController implements UpdateDocumentStatus {

    private final DocumentService documentService;

    @Override
    @PutMapping(value = "/status/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateStatus(@PathVariable("id") Long id, @RequestParam("status") String status) {
        return documentService.updateStatus(id, status);
    }

}
