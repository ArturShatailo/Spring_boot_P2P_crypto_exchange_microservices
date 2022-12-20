package com.exchange.verification.service;

import com.exchange.verification.domain.Document;
import com.exchange.verification.repository.VerificationRepository;
import com.exchange.verification.util.exceptions.VerificationNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VerificationServiceBean implements VerificationService{

    private final VerificationRepository verificationRepository;

    @Transactional
    @Override
    public void updateIdDoc(String email, Document document) {
        verificationRepository.findVerificationByEmail(email)
                .map(verification -> {
                    verification.setId_doc(document);
                    return verificationRepository.save(verification);
                })
                .orElseThrow(() -> new VerificationNotFoundException("Can't find verification request from user: " + email));
    }

    @Transactional
    @Override
    public void updateAddressDoc(String email, Document document) {
        verificationRepository.findVerificationByEmail(email)
                .map(verification -> {
                    verification.setAddress_doc(document);
                    return verificationRepository.save(verification);
                })
                .orElseThrow(() -> new VerificationNotFoundException("Can't find verification request from user: " + email));

    }

    @Transactional
    @Override
    public void updateOtherDoc(String email, Document document) {
        verificationRepository.findVerificationByEmail(email)
                .map(verification -> {
                    verification.setOther_doc(document);
                    return verificationRepository.save(verification);
                })
                .orElseThrow(() -> new VerificationNotFoundException("Can't find verification request from user: " + email));
    }
}
