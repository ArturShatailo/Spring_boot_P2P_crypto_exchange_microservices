package com.exchange.clients_management.service;

import com.exchange.clients_management.domain.Client;

public interface ClientUpdateStatusService {

    Client block(String email);

    Client unblock(String email);

    Client verify(String email);

}
