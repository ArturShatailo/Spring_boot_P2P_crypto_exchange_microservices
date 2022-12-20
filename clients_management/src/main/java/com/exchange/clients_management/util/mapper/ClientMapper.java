package com.exchange.clients_management.util.mapper;

import com.exchange.clients_management.domain.Client;
import com.exchange.clients_management.domain.dto.ClientRegisterDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ClientMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClientMapper {

    ClientRegisterDTO objectToRegisterDTO(Client object);

    Client registerDTOtoObject(ClientRegisterDTO dto);

}
