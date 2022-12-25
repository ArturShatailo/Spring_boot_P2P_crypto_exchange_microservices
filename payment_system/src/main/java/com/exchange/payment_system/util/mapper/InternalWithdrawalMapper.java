package com.exchange.payment_system.util.mapper;

import com.exchange.payment_system.domain.dto.InternalWithdrawalDTO;
import com.exchange.payment_system.domain.transactions.InternalWithdrawal;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = InternalWithdrawalMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface InternalWithdrawalMapper {

    InternalWithdrawalDTO objectToInternalWithdrawalDTO(InternalWithdrawal withdrawal);

    InternalWithdrawal internalWithdrawalDTOtoObject(InternalWithdrawalDTO dto);

}
