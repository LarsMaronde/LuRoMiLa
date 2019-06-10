package com.example.demo.bewertung.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "bewertung")
@EntityListeners(AuditingEntityListener.class)
public class Bewertung {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @NotBlank
    private int rating;

    @NotBlank
    private String beschreibung;

    @NotBlank
    private Long artikelId;

    @NotBlank
    private Long userId;


    //GETTERS AND SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Long getArtikelId() {
        return artikelId;
    }

    public void setArtikelId(Long artikelId) {
        this.artikelId = artikelId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
