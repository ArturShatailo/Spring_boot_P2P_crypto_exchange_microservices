package com.exchange.payment_system.domain.transactions;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Entity
@Table(name = "p2p_transactions")
@AllArgsConstructor
@NoArgsConstructor

public class P2PTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email_from;

    private String email_to;

    private String from_wallet;

    private String to_wallet;

    private Double amount;

    private Date timestamp = new Date();

    private String status = "NEW";

    private Long currency_id;

}
