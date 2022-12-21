package com.exchange.verification.service.impl;

import com.exchange.verification.domain.Document;
import com.exchange.verification.repository.DocumentRepository;
import com.exchange.verification.service.DocumentService;
import com.exchange.verification.service.VerificationService;
import com.exchange.verification.util.exceptions.DocumentNotFoundException;
import com.exchange.verification.util.exceptions.FileWasNotUploadedException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
@AllArgsConstructor
public class DocumentServiceBean implements DocumentService {

    private static final String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    private final DocumentRepository documentRepository;

    private final VerificationService verificationService;

    @Transactional
    @Override
    public void uploadID(MultipartFile file, String email) {
        verificationService.updateIdDoc(email, createNewDocument(file, email));
    }

    @Transactional
    @Override
    public void uploadAddress(MultipartFile file, String email) {
        verificationService.updateAddressDoc(email, createNewDocument(file, email));
    }

    @Transactional
    @Override
    public void uploadOther(MultipartFile file, String email) {
        verificationService.updateOtherDoc(email, createNewDocument(file, email));
    }

    private Document createNewDocument(MultipartFile file, String email) {
        String filePath = saveFile(file);
        return documentRepository.saveAndFlush(new Document(email, "processing", filePath));
    }

    private String saveFile(MultipartFile file) {
        try {
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
            Files.write(fileNameAndPath, file.getBytes());
            return fileNameAndPath.toString();
        } catch (IOException ioException) {
            throw new FileWasNotUploadedException("File wasn't uploaded");
        }
    }

    @Transactional
    @Override
    public String updateStatus(Long id, String status) {
        return documentRepository.findById(id)
                .map(doc -> {
                    doc.setStatus(status);
                    return documentRepository.saveAndFlush(doc);
                })
                .orElseThrow(() -> new DocumentNotFoundException("Can't find document with id: "+id))
                .getStatus();
    }
}
