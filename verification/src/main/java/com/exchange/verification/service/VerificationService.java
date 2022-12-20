package com.exchange.verification.service;

import com.exchange.verification.domain.Document;

public interface VerificationService {

    void updateIdDoc (String email, Document document);

    void updateAddressDoc (String email, Document document);

    void updateOtherDoc (String email, Document document);

}
