package com.exchange.verification.service.impl;

import com.exchange.verification.domain.Document;
import com.exchange.verification.domain.Verification;
import com.exchange.verification.service.VerificationStatusProcessingService;
import com.exchange.verification.util.configuration.VerificationConfig;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VerificationStatusProcessingServiceBean implements VerificationStatusProcessingService {

    private final VerificationConfig verificationConfig;

    @Override
    public Verification setStatus(Verification ver) {
        return validateId(ver.getId_doc()) && validateAddress(ver.getAddress_doc())
                ? verifiedClient(ver)
                : unverifiedClient(ver);
    }

    private Verification unverifiedClient(Verification ver) {

        String uri = verificationConfig.unverifyClient();
        verificationConfig.restTemplate()
                .exchange(
                        uri,
                        HttpMethod.PUT,
                        new HttpEntity<>(new HttpHeaders()),
                        void.class,
                        ver.getEmail()
                );

        ver.setStatus("UNVERIFIED");
        return ver;
    }

    private Verification verifiedClient(Verification ver) {
        String uri = verificationConfig.verifyClient();
        verificationConfig.restTemplate()
                .exchange(
                        uri,
                        HttpMethod.PUT,
                        new HttpEntity<>(new HttpHeaders()),
                        void.class,
                        ver.getEmail()
                );

        ver.setStatus("VERIFIED");
        return ver;
    }

    private boolean validateAddress(Document addressDoc) {
        if (addressDoc == null) return false;
        return addressDoc.getStatus().equals("DONE");
    }

    private boolean validateId(Document idDoc) {
        if (idDoc == null) return false;
        return idDoc.getStatus().equals("DONE");
    }

}
