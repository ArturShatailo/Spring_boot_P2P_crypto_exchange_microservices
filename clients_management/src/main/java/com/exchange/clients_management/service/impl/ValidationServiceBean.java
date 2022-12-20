package com.exchange.clients_management.service.impl;

import com.exchange.clients_management.domain.Client;
import com.exchange.clients_management.repository.ClientRepository;
import com.exchange.clients_management.service.ValidationService;
import com.exchange.clients_management.util.exceptions.EmailRegisteredException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValidationServiceBean implements ValidationService {

    private final ClientRepository clientRepository;

    @Transactional
    @Override
    public void validate(Client client) {
        validateEmail(client.getEmail());
    }

    private void validateEmail(String email) {
        clientRepository.findClientByEmail(email)
                .ifPresent(c -> {
                    throw new EmailRegisteredException("Client with email: " + email + " is already registered");
                });
    }
}
