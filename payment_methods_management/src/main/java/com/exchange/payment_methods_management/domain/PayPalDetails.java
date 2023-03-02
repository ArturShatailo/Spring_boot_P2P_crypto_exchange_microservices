package com.exchange.payment_methods_management.domain;

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

    private Boolean deleted = false;

    private Boolean active = true;

    private Long paymentMethodID;

    private String clientEmail;
}
