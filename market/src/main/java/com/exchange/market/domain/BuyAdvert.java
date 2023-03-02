package com.exchange.market.domain;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "adverts_buy")
@AllArgsConstructor
@NoArgsConstructor
public class BuyAdvert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientEmail;

    private String type = "buy";

    private String activeID;

    private String fiatID;

    private Double requestedPrice;

    private Double maxPrice;

    private String priceType;

    private Double margin;

    private Double activeAmount;

    private Double oneTransactionMinLimit;

    private Double oneTransactionMaxLimit;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private Set<Integer> paymentMethods = new HashSet<>();

    private String message;

    private Integer timeWindow;

    private String status;

    private Date timestamp;

}
