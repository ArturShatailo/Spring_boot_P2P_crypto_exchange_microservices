package com.exchange.clients_management.service.impl;

import com.exchange.clients_management.repository.ClientRepository;
import com.exchange.clients_management.service.ClientInfoService;
import com.exchange.clients_management.util.exceptions.ClientNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientInfoServiceBean implements ClientInfoService {

    private final ClientRepository clientRepository;

    @Override
    public boolean is_verified(String email) {
        return clientRepository.findClientByEmail(email)
                .orElseThrow(() -> new ClientNotFoundException("Can't find Client with email: " + email))
                .getIs_verified();
    }

    @Override
    public boolean is_blocked(String email) {
        return clientRepository.findClientByEmail(email)
                .orElseThrow(() -> new ClientNotFoundException("Can't find Client with email: " + email))
                .getIs_blocked();
    }
}
