package com.onlineshop.demo.remote;

import com.onlineshop.demo.jpa.entity.Artikel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArtikelService {

    Artikel createArtikel(Artikel artikel);

    List<Artikel> findAll();

    Artikel findOne(Long aid);

    void delete(Artikel artikel);

    ResponseEntity<Artikel> updateArtikel(Artikel artikel);


}
