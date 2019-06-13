package com.onlineshop.demo.rest;

import com.onlineshop.demo.jpa.entity.Bewertung;
import com.onlineshop.demo.remote.BewertungService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BewertungController {

    private final BewertungService bewertungService;

    public BewertungController(BewertungService bewertungService) {
        this.bewertungService = bewertungService;
    }


    @PostMapping("bewertungen")
    public Bewertung createBewertung(@RequestBody Bewertung bewertung){
        return this.bewertungService.createBewertung(bewertung);
    }

    @GetMapping("bewertungen")
    public List<Bewertung> getAllBewertungs(){
        return bewertungService.findAll();
    }

    @DeleteMapping("bewertungen/{id}")
    public ResponseEntity<Bewertung> deleteBewertung(@PathVariable(value = "id") Long bewertungid){

        Bewertung bewertung = bewertungService.findOne(bewertungid);

        if(bewertung == null){
            return ResponseEntity.notFound().build();
        }

        bewertungService.delete(bewertung);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("bewertungen/{id}")
    public ResponseEntity<Bewertung> getBewertungById(@PathVariable(value = "id") Long bewertungid){
        Bewertung bewertung = bewertungService.findOne(bewertungid);

        if(bewertung == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(bewertung);
    }


    @PutMapping("bewertungen")
    public ResponseEntity<Bewertung> updateBewertung(@RequestBody Bewertung bewertung){
        return bewertungService.updateBewertung(bewertung);
    }

    @PostMapping("users/bewertung/{artikelid}/{userid}/{rating}/{beschreibung}")
    public void rateArtikel(@PathVariable(value = "artikelid") Long artikelid,
                     @PathVariable(value = "userid") Long userid,
                     @PathVariable(value = "rating") int rating,
                     @PathVariable(value = "beschreibung") String beschreibung){
        bewertungService.rateArtikel(artikelid,userid,rating,beschreibung);
    }

}
