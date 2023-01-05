package com.exchange.payment_methods_management.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodSaveDTO {

    public String name;

    public String image;

    public String description;

}
