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
    public String updateStatus(Long id, String status) {
        return documentRepository.findById(id)
                .map(doc -> {
                    doc.setStatus(status);
                    return documentRepository.saveAndFlush(doc);
                })
                .orElseThrow(() -> new DocumentNotFoundException("Can't find document with id: "+id))
                .getStatus();
    }

    @Transactional
    @Override
    public void uploadID(MultipartFile file, String email) {
        verificationService.updateIdDoc(email, createNewDocument(file, email, "id"));
    }

    @Transactional
    @Override
    public void uploadAddress(MultipartFile file, String email) {
        verificationService.updateAddressDoc(email, createNewDocument(file, email, "address"));
    }

    @Transactional
    @Override
    public void uploadOther(MultipartFile file, String email) {
        verificationService.updateOtherDoc(email, createNewDocument(file, email, "other"));
    }

    private Document createNewDocument(MultipartFile file, String email, String type) {
        Document document = new Document(email, "processing", type);
        String filePath = saveFile(file, document.nameConstructor());
        document.setScan_doc(filePath);
        return documentRepository.saveAndFlush(document);
    }

    private String saveFile(MultipartFile file, String name) {
        try {
            //Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, name + "_" + file.getOriginalFilename());
            Files.write(fileNameAndPath, file.getBytes());
            return fileNameAndPath.toString();
        } catch (IOException ioException) {
            throw new FileWasNotUploadedException("File wasn't uploaded");
        }
    }
}
