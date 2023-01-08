package com.exchange.market.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Entity
@Table(name = "orders_buy")
@AllArgsConstructor
@NoArgsConstructor
public class BuyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @OneToOne(cascade = CascadeType.ALL)
    private BuyAdvert advert;

    private Double fiatAmount;

    private Double activeAmount;

    private Double price;

    private Long paymentNotificationID;

    private Long p2pPaymentID;

    private Date timestamp;

}
