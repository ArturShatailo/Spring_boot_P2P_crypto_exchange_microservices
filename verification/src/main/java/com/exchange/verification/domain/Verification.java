package com.exchange.verification.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "verifications")
@AllArgsConstructor
@NoArgsConstructor
public class Verification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    private Document id_doc;

    @OneToOne(cascade = CascadeType.ALL)
    private Document address_doc;

    @OneToOne(cascade = CascadeType.ALL)
    private Document other_doc;


}
