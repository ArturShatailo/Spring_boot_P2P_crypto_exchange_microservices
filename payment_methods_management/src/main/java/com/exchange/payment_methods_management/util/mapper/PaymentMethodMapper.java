package com.exchange.payment_methods_management.util.mapper;

import com.exchange.payment_methods_management.domain.PaymentMethod;
import com.exchange.payment_methods_management.domain.dto.PaymentMethodSaveDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = PaymentMethodMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PaymentMethodMapper {

    PaymentMethodSaveDTO objectToPaymentMethodSaveDTO(PaymentMethod object);

    PaymentMethod paymentMethodSaveDTOtoObject(PaymentMethodSaveDTO dto);

}
