package com.onlineshop.demo.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name ="id")
    private Long id;

    @NotNull
    @Column(name ="username", unique = true)
    private String username;

    @NotNull
    @Column(name ="vorname")
    private String vorname;

    @NotNull
    @Column(name ="nachname")
    private String nachname;

    @NotNull
    @Column(name ="email")
    private String email;

    @NotNull
    @Column(name ="dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @NotNull
    @Column(name ="password")
    private String password;

    @NotNull
    @Column(name ="adresse")
    private String adresse;


    //getters setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
