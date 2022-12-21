package com.exchange.verification.service.impl;

import com.exchange.verification.domain.Verification;
import com.exchange.verification.repository.VerificationRepository;
import com.exchange.verification.service.ValidationService;
import com.exchange.verification.service.VerificationRegistrationService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VerificationRegistrationServiceBean implements VerificationRegistrationService {

    private final VerificationRepository verificationRepository;

    private final ValidationService validationService;

    @Transactional
    @Override
    public void newVerification(String email) {
        Verification verification = Verification.builder()
                .status("NEW")
                .email(email)
                .build();
        validationService.validate(verification);
        verificationRepository.save(verification);
    }

}
