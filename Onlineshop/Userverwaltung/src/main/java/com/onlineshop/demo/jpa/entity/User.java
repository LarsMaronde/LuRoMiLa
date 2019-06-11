package com.onlineshop.demo.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private String username;
    private String vorname;
    private String nachname;

    private String email;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private String password;

    private String adresse;

}
