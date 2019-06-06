package com.onlineshop.warenverwaltung.demo.Produkt.Model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name ="Produkt")
public class Produkt {

    @Column(name ="name")
    private String name;

    @Column(name ="artikelnummer")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int artikelnummer;

    @Column(name = "preis")
    private float preis;


    public Produkt(){
        //default Konstruktor
    }

    public Produkt(String name, int artikelnummer, float preis){
        setArtikelnummer(artikelnummer);
        setName(name);
        setPreis(preis);
    }

    public String getName() {
        return name;
    }
    public int getArtikelnummer() {
        return artikelnummer;
    }
    public float getPreis() {
        return preis;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setArtikelnummer(int artikelnummer) {
        this.artikelnummer = artikelnummer;
    }
    public void setPreis(float preis) {
        this.preis = preis;
    }
    }

