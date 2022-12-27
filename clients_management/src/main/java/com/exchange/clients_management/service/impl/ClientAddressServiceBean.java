package com.exchange.clients_management.service.impl;

import com.exchange.clients_management.domain.Address;
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
    public void add(Address address) {
        addressRepository.findAddressByClientID(address.getClientID())
                .ifPresentOrElse(
                        a -> updateExistingAddress(a, address),
                        () -> updateNewAddress(address));
    }

    private void updateNewAddress(Address address){
        clientRepository.findById(address.getClientID())
                .map(c -> {
                    c.setAddress(address);
                    return clientRepository.save(c);
                })
                .orElseThrow(() -> new ClientNotFoundException("Can't find client with id: " + address.getClientID()));
    }

    private void updateExistingAddress(Address a, Address address) {
        a.setCity(address.getCity());
        a.setState(address.getState());
        a.setCountry(address.getCountry());
        a.setPostalCode(address.getPostalCode());
        a.setDetails(address.getDetails());
        addressRepository.save(a);
    }
}
