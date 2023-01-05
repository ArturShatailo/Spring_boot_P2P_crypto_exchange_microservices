package com.exchange.payment_methods_management.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bank_details")
public class BankDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String iban;

    private String name;

    private String surname;

    private Boolean deleted = false;

    private Boolean active = true;

    @ManyToOne(cascade = CascadeType.ALL)
    private PaymentMethod paymentMethod;

    @ManyToOne(cascade = CascadeType.ALL)
    private Bank bank;

    private String clientEmail;

}
