package com.exchange.verification.service;

import com.exchange.verification.domain.Document;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {

    void update (Long id, Document document);

    void uploadID(MultipartFile file, String email);

    void uploadAddress(MultipartFile file, String email);

    void uploadOther(MultipartFile file, String email);

}
