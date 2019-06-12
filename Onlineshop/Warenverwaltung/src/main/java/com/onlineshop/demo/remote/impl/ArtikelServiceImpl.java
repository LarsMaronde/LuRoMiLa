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

    @HystrixCommand(fallbackMethod = "reliable3")
    @Override
    public void delete(Artikel artikel) {
        repository.delete(artikel);
    }

    @HystrixCommand(fallbackMethod = "reliable3")
    @Override
    public Artikel updateArtikel(Artikel artikel) {
        return repository.save(artikel);
    }

    @Override
    public Artikel findArtikelByName(String name) {
        return repository.findArtikelByName(name);
    }

    public ResponseEntity<Artikel> reliable() {
        Artikel artikel = new Artikel();
        artikel.setName("default-fallback");
        return ResponseEntity.ok(artikel);
    }


    public ArrayList<Artikel> reliable2(){
        return new ArrayList<Artikel>();
    }

    public ResponseEntity<Artikel> reliable3(){
        return ResponseEntity.notFound().build();
    }
}

