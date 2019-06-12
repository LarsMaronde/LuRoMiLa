package com.onlineshop.demo.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name="Artikel")
public class Artikel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "beschreibung")
    private String beschreibung;
    @Column(name = "preis")
    private float preis;

    @Column(name = "einstellungsdatum")
    @Temporal(TemporalType.DATE)
    private Date einstellungsdatum;


    //getters setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }

    public Date getEinstellungsdatum() {
        return einstellungsdatum;
    }

    public void setEinstellungsdatum(Date einstellungsdatum) {
        this.einstellungsdatum = einstellungsdatum;
    }
}
