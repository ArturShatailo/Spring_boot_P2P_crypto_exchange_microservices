package com.exchange.payment_system.util.mapper;

import com.exchange.payment_system.domain.dto.InternalDepositDTO;
import com.exchange.payment_system.domain.transactions.InternalDeposit;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = InternalDepositMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface InternalDepositMapper {

    InternalDepositDTO objectToInternalDepositDTO(InternalDeposit deposit);

    InternalDeposit internalDepositDTOtoObject(InternalDepositDTO dto);

}
