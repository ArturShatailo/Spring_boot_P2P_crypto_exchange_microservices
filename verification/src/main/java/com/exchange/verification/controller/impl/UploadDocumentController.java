package com.exchange.verification.controller.impl;

import com.exchange.verification.controller.UploadDocument;
import com.exchange.verification.service.DocumentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping(value = "/api/verification")
@AllArgsConstructor
public class UploadDocumentController implements UploadDocument {

    private final DocumentService documentService;

    @Override
    @PostMapping(value = "/id")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadID(@RequestParam("file") MultipartFile file, @RequestParam("email") String email) {
        documentService.uploadID(file, email);
    }

    @Override
    @PostMapping(value = "/address")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadAddress(@RequestParam("file") MultipartFile file, @RequestParam("email") String email) {
        documentService.uploadAddress(file, email);
    }

    @Override
    @PostMapping(value = "/other")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadOther(@RequestParam("file") MultipartFile file, @RequestParam("email") String email) {
        documentService.uploadOther(file, email);
    }

}
