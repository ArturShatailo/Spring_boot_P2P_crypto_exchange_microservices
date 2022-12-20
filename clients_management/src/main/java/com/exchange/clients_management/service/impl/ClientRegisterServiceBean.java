package com.exchange.clients_management.service.impl;

import com.exchange.clients_management.domain.Client;
import com.exchange.clients_management.repository.ClientRepository;
import com.exchange.clients_management.service.ClientRegisterService;
import com.exchange.clients_management.service.ValidationService;
import com.exchange.clients_management.util.configuration.ClientConfig;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientRegisterServiceBean implements ClientRegisterService {

    private final ClientRepository clientRepository;

    private final ValidationService validationService;

    private final ClientConfig clientConfig;

    @Transactional
    @Override
    public Client register(Client client) {
        validationService.validate(client);
        verificationHandler(client.getEmail());
        return clientRepository.save(client);
    }

    private void verificationHandler(String email) {
        String uri = clientConfig.verificationCreate();
        clientConfig.restTemplate().exchange(uri, HttpMethod.POST, new HttpEntity<>(new HttpHeaders()), void.class, email);
    }
}
