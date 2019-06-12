package com.onlineshop.demo.rest;

import com.onlineshop.demo.jpa.entity.Artikel;
import com.onlineshop.demo.remote.ArtikelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtikelController {

    private final ArtikelService artikelService;

    public ArtikelController(ArtikelService artikelService) {
        this.artikelService = artikelService;
    }

    @PostMapping("artikel")
    public Artikel createArtikel(@RequestBody Artikel artikel){
        return this.artikelService.createArtikel(artikel);
    }

    @GetMapping("artikel")
    public List<Artikel> getAllArtikel(){
        return artikelService.findAll();
    }

    @DeleteMapping("artikel/{id}")
    public ResponseEntity<Artikel> deleteArtikel(@PathVariable(value = "id") Long artikelid){

        Artikel artikel = artikelService.findOne(artikelid);

        if(artikel == null){
            return ResponseEntity.notFound().build();
        }

        artikelService.delete(artikel);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("artikel/{id}")
    public ResponseEntity<Artikel> getArtikelById(@PathVariable(value = "id") Long artikelid){
        Artikel artikel = artikelService.findOne(artikelid);

        if(artikel == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(artikel);
    }

    @PutMapping("artikel")
    public ResponseEntity<Artikel> updateUser(@RequestBody Artikel artikel){
        return artikelService.updateArtikel(artikel);
    }

    @GetMapping("users/bestand/{id}")
    public int getBestand(@PathVariable(value = "id") Long artikelid){
        return artikelService.findOne(artikelid).getBestand();
    }



}
