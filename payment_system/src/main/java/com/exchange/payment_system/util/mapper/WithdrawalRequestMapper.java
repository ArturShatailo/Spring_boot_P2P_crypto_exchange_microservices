package com.exchange.payment_system.util.mapper;

import com.exchange.payment_system.domain.transactions.WithdrawalRequest;
import com.exchange.payment_system.domain.dto.WithdrawalRequestDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = WithdrawalRequestMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface WithdrawalRequestMapper {

    WithdrawalRequestDTO objectToWithdrawalRequestDTO(WithdrawalRequest withdrawalRequest);

    WithdrawalRequest withdrawalRequestDTOtoObject(WithdrawalRequestDTO dto);

}
