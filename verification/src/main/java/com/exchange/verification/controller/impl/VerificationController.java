package com.exchange.verification.controller.impl;

import com.exchange.verification.controller.DownloadDocument;
import com.exchange.verification.controller.VerificationRegistration;
import com.exchange.verification.service.DocumentService;
import com.exchange.verification.service.VerificationRegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping(value = "/api/verification")
@AllArgsConstructor
public class VerificationController implements DownloadDocument, VerificationRegistration {

    private final DocumentService documentService;

    private final VerificationRegistrationService verificationRegistrationService;

    @Override
    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public void newVerification(@RequestParam("email") String email) {
        verificationRegistrationService.newVerification(email);
    }

    @Override
    @PostMapping(value = "/id")
    @ResponseStatus(HttpStatus.CREATED)
    public String uploadID(@RequestParam("file") MultipartFile file,  @RequestParam("email") String email) {
        return documentService.uploadID(file, email);
    }

    @Override
    @PostMapping(value = "/address")
    @ResponseStatus(HttpStatus.CREATED)
    public String uploadAddress(@RequestParam("file") MultipartFile file, @RequestParam("email") String email) {
        return documentService.uploadAddress(file, email);
    }

    @Override
    @PostMapping(value = "/other")
    @ResponseStatus(HttpStatus.CREATED)
    public String uploadOther(@RequestParam("file") MultipartFile file, @RequestParam("email") String email) {
        return documentService.uploadOther(file, email);
    }
}
