package com.payment_methods_management.domain;

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

    @ManyToOne(cascade = CascadeType.ALL)
    private PaymentMethod paymentMethod;

    @ManyToOne(cascade = CascadeType.ALL)
    private Bank bank_issuer;

    private Long client_id;
}
