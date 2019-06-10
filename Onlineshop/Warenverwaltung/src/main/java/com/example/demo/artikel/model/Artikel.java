package com.example.demo.artikel.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "artikel")
@EntityListeners(AuditingEntityListener.class)
public class Artikel {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private String beschreibung;

    @NotBlank
    private String name;

    @NotBlank
    private float preis;

    //GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }

}
