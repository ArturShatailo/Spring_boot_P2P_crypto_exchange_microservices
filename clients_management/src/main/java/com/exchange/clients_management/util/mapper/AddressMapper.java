package com.exchange.clients_management.util.mapper;

import com.exchange.clients_management.domain.Address;
import com.exchange.clients_management.domain.dto.AddressDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AddressMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AddressMapper {

    AddressDTO objectToAddressDTO(Address object);

    Address addressDTOtoObject(AddressDTO dto);

}
