package com.exchange.clients_management.service.impl;

import com.exchange.clients_management.domain.Client;
import com.exchange.clients_management.repository.ClientRepository;
import com.exchange.clients_management.service.ClientRegisterService;
import com.exchange.clients_management.service.ClientVerificationService;
import com.exchange.clients_management.service.ValidationService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientRegisterServiceBean implements ClientRegisterService {

    private final ClientRepository clientRepository;

    private final ValidationService validationService;

    private final ClientVerificationService clientVerificationService;

    @Transactional
    @Override
    public Client register(Client client) {
        validationService.validate(client);
        clientVerificationService.addVerification(client);
        return clientRepository.save(client);
    }
}
