package com.exchange.clients_management.service.impl;

import com.exchange.clients_management.domain.Client;
import com.exchange.clients_management.repository.ClientRepository;
import com.exchange.clients_management.service.ClientUpdateStatusService;
import com.exchange.clients_management.util.exceptions.ClientNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientUpdateStatusServiceBean implements ClientUpdateStatusService {

    private final ClientRepository clientRepository;

    @Override
    public Client block(Long id) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setIs_blocked(true);
                    return clientRepository.save(client);
                })
                .orElseThrow(() -> new ClientNotFoundException("Can't find Client with id: " + id));
    }

    @Override
    public Client unblock(Long id) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setIs_blocked(false);
                    return clientRepository.save(client);
                })
                .orElseThrow(() -> new ClientNotFoundException("Can't find Client with id: " + id));
    }

    @Override
    public Client verify(String email) {
        return clientRepository.findClientByEmail(email)
                .map(client -> {
                    client.setIs_verified(true);
                    return clientRepository.save(client);
                })
                .orElseThrow(() -> new ClientNotFoundException("Can't find Client with email: " + email));
    }

    @Override
    public Client unverify(String email) {
        return clientRepository.findClientByEmail(email)
                .map(client -> {
                    client.setIs_verified(false);
                    return clientRepository.save(client);
                })
                .orElseThrow(() -> new ClientNotFoundException("Can't find Client with email: " + email));
    }
}
