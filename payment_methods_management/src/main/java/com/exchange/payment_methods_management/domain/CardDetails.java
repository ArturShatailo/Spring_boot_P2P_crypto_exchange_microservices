package com.exchange.payment_methods_management.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "card_details")
public class CardDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String name;

    private String surname;

    private Boolean deleted = false;

    private Boolean active = true;

    @ManyToOne(cascade = CascadeType.MERGE)
    private PaymentMethod paymentMethod;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Bank bankIssuer;

    private String clientEmail;
}
