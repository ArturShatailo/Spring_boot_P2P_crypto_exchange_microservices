package com.exchange.payment_methods_management.util.mapper;

import com.exchange.payment_methods_management.domain.PayPalDetails;
import com.exchange.payment_methods_management.domain.dto.PayPalDetailsDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = PayPalDetailsMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PayPalDetailsMapper {

    PayPalDetailsDTO objectToPayPalDetailsDTO(PayPalDetails object);

    PayPalDetails payPalDetailsDTOtoObject(PayPalDetailsDTO dto);

}
