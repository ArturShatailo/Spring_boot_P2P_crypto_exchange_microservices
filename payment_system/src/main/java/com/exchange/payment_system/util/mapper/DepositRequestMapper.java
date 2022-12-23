package com.exchange.payment_system.util.mapper;

import com.exchange.payment_system.domain.DepositRequest;
import com.exchange.payment_system.domain.dto.DepositRequestDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = DepositRequestMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DepositRequestMapper {

    DepositRequestDTO objectToDepositRequestDTO(DepositRequest depositRequest);

    DepositRequest depositRequestDTOtoObject(DepositRequestDTO dto);

}
