package com.exchange.verification.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "documents")
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String status;

    private String scan_doc;

    public Document(String email, String status, String scan_doc){
        this.email = email;
        this.scan_doc = scan_doc;
        this.status = status;
    }

}
