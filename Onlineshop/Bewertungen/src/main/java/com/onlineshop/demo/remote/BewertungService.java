package com.onlineshop.demo.remote;

import com.onlineshop.demo.jpa.entity.Bewertung;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BewertungService {

    Bewertung createBewertung(Bewertung bewertung);

    List<Bewertung> findAll();

    Bewertung findOne(Long bid);

    void delete(Bewertung bewertung);

    ResponseEntity<Bewertung> updateBewertung(Bewertung bewertung);


}
