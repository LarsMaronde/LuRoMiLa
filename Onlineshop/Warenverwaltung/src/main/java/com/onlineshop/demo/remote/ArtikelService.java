package com.onlineshop.demo.remote;

import com.onlineshop.demo.jpa.entity.Artikel;

import java.util.List;

public interface ArtikelService {

    Artikel createArtikel(Artikel artikel);

    List<Artikel> findAll();

    Artikel findOne(Long aid);

    void delete(Artikel artikel);

    Artikel updateArtikel(Artikel artikel);

    Artikel findArtikelByName(String name);




}
