package com.onlineshop.bewertung.demo.model;

import javax.persistence.*;

@Entity
public class Bewertung {

    @Column(name = "text")
    private String text;
    @Column(name = "sterne")
    private int sterne;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSterne() {
        return sterne;
    }

    public void setSterne(int sterne) {
        this.sterne = sterne;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
