package com.exchange.clients_management.service;

public interface ClientInfoService {

    boolean is_verified(String email);

    boolean is_blocked(String email);

}
