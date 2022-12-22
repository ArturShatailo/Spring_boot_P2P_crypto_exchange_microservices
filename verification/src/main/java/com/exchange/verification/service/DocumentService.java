package com.exchange.verification.service;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {

    String updateStatus (Long id, String status);

    void uploadID(MultipartFile file, String email);

    void uploadAddress(MultipartFile file, String email);

    void uploadOther(MultipartFile file, String email);

}
