package com.exchange.clients_management.service.impl;

import com.exchange.clients_management.domain.Address;
import com.exchange.clients_management.domain.Client;
import com.exchange.clients_management.repository.AddressRepository;
import com.exchange.clients_management.repository.ClientRepository;
import com.exchange.clients_management.service.ClientAddressService;
import com.exchange.clients_management.util.exceptions.ClientNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientAddressServiceBean implements ClientAddressService {

    private final ClientRepository clientRepository;

    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public Address add(Address address, Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Can't find client with id: " + id));
        client.setAddress(address);
        return clientRepository.save(client).getAddress();
    }
}
