package com.onlineshop.demo.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "Bewertung")
public class Bewertung {

    public Bewertung() {
        /*empty*/
    }

    public Bewertung(@NotNull int rating, @NotNull String ratingText, @NotNull Long artikelId, @NotNull Long userId) {
        this.rating = rating;
        this.ratingText = ratingText;
        this.artikelId = artikelId;
        this.userId = userId;
        this.ratedAt = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "rating")
    private int rating;

    @NotNull
    @Column(name = "ratedAt")
    @Temporal(TemporalType.DATE)
    private Date ratedAt;

    @NotNull
    @Column(name = "ratingText")
    private String ratingText;

    @NotNull
    @Column(name = "artikelId")
    private Long artikelId;

    @NotNull
    @Column(name = "userId")
    private Long userId;

    //getters setters


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

    public Date getRatedAt() {
        return ratedAt;
    }

    public void setRatedAt(Date ratedAt) {
        this.ratedAt = ratedAt;
    }

    public String getRatingText() {
        return ratingText;
    }

    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
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
