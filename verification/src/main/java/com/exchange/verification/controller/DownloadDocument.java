package com.exchange.verification.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface DownloadDocument {

    @PostMapping(value = "/id")
    String uploadID(@RequestParam("file") MultipartFile file,  @RequestParam("email") String email);

    @PostMapping(value = "/address")
    String uploadAddress(@RequestParam("file") MultipartFile file, @RequestParam("email") String email);

    @PostMapping(value = "/other")
    String uploadOther(@RequestParam("file") MultipartFile file, @RequestParam("email") String email);

}
