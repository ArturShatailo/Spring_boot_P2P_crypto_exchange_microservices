package com.exchange.payment_methods_management.util.mapper;

import com.exchange.payment_methods_management.domain.CardDetails;
import com.exchange.payment_methods_management.domain.dto.CardDetailsDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CardDetailsMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CardDetailsMapper {

    CardDetailsDTO objectToCardDetailsDTO(CardDetails object);

    CardDetails cardDetailsDTOtoObject(CardDetailsDTO dto);

}
