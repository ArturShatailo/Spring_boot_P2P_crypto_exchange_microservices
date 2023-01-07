package com.exchange.market.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
public class BuyAdvertDTO {

    public String clientEmail;

    public String activeID;

    public String fiatID;

    public Double requestedPrice;

    public Double maxPrice;

    public String priceType;

    public Double margin;

    public Double activeAmount;

    public Double oneTransactionMinLimit;

    public Double oneTransactionMaxLimit;

    public Set<Integer> paymentMethods;

    public String message;

    public Integer timeWindow;

    public String status = "NEW";

    public Date timestamp = new Date();

}
