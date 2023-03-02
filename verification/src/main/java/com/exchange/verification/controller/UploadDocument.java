package com.exchange.verification.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface UploadDocument {

    @PostMapping(value = "/id")
    void uploadID(@RequestParam("file") MultipartFile file,  @RequestParam("email") String email);

    @PostMapping(value = "/address")
    void uploadAddress(@RequestParam("file") MultipartFile file, @RequestParam("email") String email);

    @PostMapping(value = "/other")
    void uploadOther(@RequestParam("file") MultipartFile file, @RequestParam("email") String email);

}
