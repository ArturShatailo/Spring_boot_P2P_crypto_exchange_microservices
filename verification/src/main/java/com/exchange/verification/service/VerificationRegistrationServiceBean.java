package com.exchange.verification.service;

import com.exchange.verification.domain.Verification;
import com.exchange.verification.repository.VerificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VerificationRegistrationServiceBean implements VerificationRegistrationService{

    private final VerificationRepository verificationRepository;

    @Override
    public void newVerification(String email) {
        Verification verification = new Verification();
        verification.setStatus("NEW");
        verification.setEmail(email);
        verificationRepository.save(verification);
    }
}
