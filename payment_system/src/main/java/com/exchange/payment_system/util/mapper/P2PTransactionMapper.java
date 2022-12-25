package com.exchange.payment_system.util.mapper;

import com.exchange.payment_system.domain.dto.P2PTransactionDTO;
import com.exchange.payment_system.domain.transactions.P2PTransaction;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = P2PTransactionMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface P2PTransactionMapper {

    P2PTransactionDTO objectToDepositRequestDTO(P2PTransaction transaction);

    P2PTransaction p2pTransactionDTOtoObject(P2PTransactionDTO dto);

}
