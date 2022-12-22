package com.exchange.clients_management.service.impl;

import com.exchange.clients_management.domain.Client;
import com.exchange.clients_management.service.ClientVerificationService;
import com.exchange.clients_management.util.configuration.ClientConfig;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientVerificationServiceBean implements ClientVerificationService {

    private final ClientConfig clientConfig;

    @Override
    public void addVerification(Client client) {
        String uri = clientConfig.verificationCreate();
        clientConfig.restTemplate()
                .exchange(
                        uri,
                        HttpMethod.POST,
                        new HttpEntity<>(new HttpHeaders()),
                        void.class,
                        client.getEmail()
                );
    }

}
