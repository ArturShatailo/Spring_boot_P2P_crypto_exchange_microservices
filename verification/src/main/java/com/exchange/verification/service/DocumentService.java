package com.exchange.verification.service;

import com.exchange.verification.domain.Document;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {

    Document create (Document document);

    void update (Long id, Document document);

    String uploadID(MultipartFile file, String email);

    String uploadAddress(MultipartFile file, String email);

    String uploadOther(MultipartFile file, String email);

}
