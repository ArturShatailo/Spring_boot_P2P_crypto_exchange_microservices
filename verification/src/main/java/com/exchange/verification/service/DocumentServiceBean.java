package com.exchange.verification.service;

import com.exchange.verification.domain.Document;
import com.exchange.verification.repository.DocumentRepository;
import com.exchange.verification.util.exceptions.DocumentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
@AllArgsConstructor
public class DocumentServiceBean implements DocumentService{

    private static final String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    private final DocumentRepository documentRepository;

    private final VerificationService verificationService;


    @Override
    public String uploadID(MultipartFile file, String email) {
        String filePath = saveFile(file);
        Document document = documentRepository.saveAndFlush(new Document(email, "processing", filePath));
        verificationService.updateAddressDoc(email, document);
        return filePath;
    }

    @Override
    public String uploadAddress(MultipartFile file, String email) {
        String filePath = saveFile(file);
        Document document = documentRepository.saveAndFlush(new Document(email, "processing", filePath));
        verificationService.updateOtherDoc(email, document);
        return filePath;
    }

    @Override
    public String uploadOther(MultipartFile file, String email) {
        String filePath = saveFile(file);
        Document document = documentRepository.saveAndFlush(new Document(email, "processing", filePath));
        verificationService.updateIdDoc(email, document);
        return filePath;
    }

    private String saveFile(MultipartFile file) {
        try {
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
            Files.write(fileNameAndPath, file.getBytes());
            return fileNameAndPath.toString();
        } catch (IOException ioException) {
            System.err.println("File wasn't uploaded");
            return null;
        }
    }

    @Override
    public Document create(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public void update(Long id, Document document) {
        documentRepository.findById(id)
                .map(doc -> {
                    doc.setScan_doc(doc.getScan_doc());
                    doc.setStatus(doc.getStatus());
                    return documentRepository.save(doc);
                })
                .orElseThrow(() -> new DocumentNotFoundException("Can't find document with id: "+id));
    }
}
