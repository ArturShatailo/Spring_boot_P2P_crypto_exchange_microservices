package com.exchange.clients_management.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Entity
@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String middle_name;

    private String nickname;

    private String phone_number;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private String email;

    private String password;

    private Date registration_date;

    private Boolean is_verified = false;

    private Boolean is_blocked = false;

}
