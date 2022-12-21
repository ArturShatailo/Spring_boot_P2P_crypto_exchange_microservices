package com.exchange.verification.service;

import com.exchange.verification.domain.Verification;
import com.exchange.verification.repository.VerificationRepository;
import com.exchange.verification.util.exceptions.VerificationExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValidationServiceBean implements ValidationService{

    private final VerificationRepository verificationRepository;

    @Override
    public void validate(Verification verification) {
        validateEmail(verification.getEmail());
    }

    private void validateEmail(String email) {
        verificationRepository.findVerificationByEmail(email)
                .ifPresent(c -> {
                    throw new VerificationExistsException("Verification request with email: " + email + " is already exists");
                });
    }

}
