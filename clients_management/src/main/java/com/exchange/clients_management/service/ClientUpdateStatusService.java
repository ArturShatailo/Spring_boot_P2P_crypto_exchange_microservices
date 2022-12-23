package com.exchange.clients_management.service;

import com.exchange.clients_management.domain.Client;

public interface ClientUpdateStatusService {

    Client block(Long id);

    Client unblock(Long id);

    Client verify(String email);

    Client unverify(String email);

}
