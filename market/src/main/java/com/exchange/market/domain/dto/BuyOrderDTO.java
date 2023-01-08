package com.exchange.market.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
public class BuyOrderDTO {

    public String clientEmail;

    public Double fiatAmount;

    public Double activeAmount;

    public Set<Integer> paymentMethods;

    public Date timestamp = new Date();

}
