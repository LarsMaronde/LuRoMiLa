package com.onlineshop.demo.remote.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.onlineshop.demo.jpa.ArtikelRepository;
import com.onlineshop.demo.jpa.entity.Artikel;
import com.onlineshop.demo.remote.ArtikelService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtikelServiceImpl implements ArtikelService {

    private final ArtikelRepository repository;


    public ArtikelServiceImpl(ArtikelRepository repository) {
        this.repository = repository;
    }


    @HystrixCommand(fallbackMethod = "reliable")
    @Override
    public Artikel createArtikel(Artikel artikel) {
        return repository.save(artikel);
    }

    @HystrixCommand(fallbackMethod = "reliable2")
    @Override
    public List<Artikel> findAll() {
        Iterable<Artikel> entitites = repository.findAll();
        ArrayList<Artikel> artikelList = new ArrayList<Artikel>();
        entitites.forEach(artikel -> artikelList.add(artikel));
        return artikelList;
    }

    @HystrixCommand(fallbackMethod = "reliable3")
    @Override
    public Artikel findOne(Long aid) {
        return repository.findById(aid).get();
    }


    @Override
    public void delete(Artikel artikel) {
        repository.delete(artikel);
    }

    @HystrixCommand(fallbackMethod = "reliable4")
    @Override
    public ResponseEntity<Artikel> updateArtikel(Artikel artikelDetails) {

        Artikel artikel = repository.findById(artikelDetails.getId()).get();

        if(artikel == null){
            return ResponseEntity.notFound().build();
        }
        artikel.setName(artikelDetails.getName());
        artikel.setBeschreibung(artikelDetails.getBeschreibung());
        artikel.setEinstellungsdatum(artikelDetails.getEinstellungsdatum());
        artikel.setPreis(artikelDetails.getPreis());
        artikel.setBestand(artikelDetails.getBestand());

        repository.deleteById(artikel.getId());
        repository.save(artikel);

        return ResponseEntity.ok(artikel);
    }



    //resilience fallback

    public Artikel reliable(Artikel artikel){
        Artikel artikel1 = new Artikel();
        artikel1.setName("default fallback");
        return artikel1;
    }

    public List<Artikel> reliable2(){
        return new ArrayList<Artikel>();
    }

    public Artikel reliable3(Long id){
        Artikel a = new Artikel();
        a.setName("default fallback");
        return a;
    }

    public ResponseEntity<Artikel> reliable4(Artikel artikel){
        return ResponseEntity.notFound().build();
    }
}

