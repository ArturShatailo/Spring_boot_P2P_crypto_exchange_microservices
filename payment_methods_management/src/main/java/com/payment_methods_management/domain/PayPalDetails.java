package com.payment_methods_management.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "paypal_details")
public class PayPalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    private String surname;

    @ManyToOne(cascade = CascadeType.ALL)
    private PaymentMethod paymentMethod;

    private Long client_id;
}
