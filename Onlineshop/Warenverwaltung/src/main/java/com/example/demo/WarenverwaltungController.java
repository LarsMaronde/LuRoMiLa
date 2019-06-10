package com.example.demo;

import com.example.demo.artikel.dao.ArtikelDAO;
import com.example.demo.artikel.model.Artikel;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/warenverwaltung")
public class WarenverwaltungController {

    @Autowired
    ArtikelDAO artikelDAO;

    // save artikel into database
    @HystrixCommand(fallbackMethod = "reliable")
    @PostMapping("/artikel")
    public Artikel createartikel(@Valid @RequestBody Artikel artikel){
        return artikelDAO.save(artikel);
    }

    //get all artikels
    @HystrixCommand(fallbackMethod = "reliable2")
    @GetMapping("/artikel")
    public List<Artikel> getAllartikels(){
        return artikelDAO.findAll();
    }

    //get artikel by id
    @HystrixCommand(fallbackMethod = "reliable3")
    @GetMapping("/artikel/{id]")
    public ResponseEntity<Artikel> getartikelById(@PathVariable(value = "id") Long artikelid){
        Artikel artikel = artikelDAO.findOne(artikelid);

        if(artikel == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(artikel);
    }

    //update an artikel
    @PutMapping("/artikels/{id}")
    public ResponseEntity<Artikel> updateartikel(@PathVariable(value = "id") Long artikelid,
                                                 @Valid @RequestBody Artikel artikelDetails){
        Artikel artikel = artikelDAO.findOne(artikelid);

        if(artikel == null){
            return ResponseEntity.notFound().build();
        }
        artikel.setBeschreibung(artikelDetails.getBeschreibung());
        artikel.setName(artikelDetails.getName());
        artikel.setPreis(artikelDetails.getPreis());

        Artikel updateArtikel = artikelDAO.save(artikel);
        return ResponseEntity.ok().body(updateArtikel);
    }

    //delete an artikel
    @DeleteMapping("/artikels/{id}")
    public ResponseEntity<Artikel> deleteartikel(@PathVariable(value = "id") Long artikelid){

        Artikel artikel = artikelDAO.findOne(artikelid);

        if(artikel == null){
            return ResponseEntity.notFound().build();
        }

        artikelDAO.delete(artikel);
        return  ResponseEntity.ok().build();
    }
}
