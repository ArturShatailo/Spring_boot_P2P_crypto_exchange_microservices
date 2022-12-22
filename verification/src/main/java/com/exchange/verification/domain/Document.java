package com.exchange.verification.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

    private String type;

    private Date date = new Date();

    public Document(String email, String status, String type){
        this.email = email;
        this.type = type;
        this.status = status;
    }

    public String nameConstructor(){
        return email + "_" + type + "_" + date.getTime();
    }

}
