package com.onlineshop.demo.remote.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.onlineshop.demo.jpa.BewertungRepository;
import com.onlineshop.demo.jpa.entity.Bewertung;
import com.onlineshop.demo.remote.BewertungService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BewertungServiceImpl implements BewertungService {


    private final BewertungRepository repository;


    public BewertungServiceImpl(BewertungRepository repository) {
        this.repository = repository;
    }


    @HystrixCommand(fallbackMethod = "reliable")
    @Override
    public Bewertung createBewertung(Bewertung bewertung) {
        return repository.save(bewertung);
    }

    @HystrixCommand(fallbackMethod = "reliable2")
    @Override
    public List<Bewertung> findAll() {
        Iterable<Bewertung> entities = repository.findAll();
        ArrayList<Bewertung> bewertungList = new ArrayList<Bewertung>();
        entities.forEach(bewertung -> bewertungList.add(bewertung));
        return bewertungList;
    }

    @HystrixCommand(fallbackMethod = "reliable3")
    @Override
    public Bewertung findOne(Long uid) {
        return repository.findById(uid).get();
    }

    @Override
    public void delete(Bewertung bewertung) {
        repository.delete(bewertung);
    }

    @HystrixCommand(fallbackMethod = "reliable4")
    @Override
    public ResponseEntity<Bewertung> updateBewertung(Bewertung bewertungDetails) {

        Bewertung bewertung = repository.findById(bewertungDetails.getId()).get();

        if(bewertung == null){
            return ResponseEntity.notFound().build();
        }

        bewertung.setRating(bewertungDetails.getRating());
        bewertung.setArtikelId(bewertungDetails.getArtikelId());
        bewertung.setRatingText(bewertungDetails.getRatingText());
        bewertung.setUserId(bewertungDetails.getUserId());
        bewertung.setRatedAt(bewertungDetails.getRatedAt());

        repository.deleteById(bewertung.getId());
        repository.save(bewertung);

        return ResponseEntity.ok(bewertung);
    }


    @Override
    public void rateArtikel(Long artikelid, Long userid, int rating, String beschreibung) {
        Bewertung b = new Bewertung(rating, beschreibung,artikelid,userid);
        repository.save(b);
    }

    //resilience fallback

    public Bewertung reliable(Bewertung bewertung){
        Bewertung bewertung1 = new Bewertung();
        bewertung1.setRating(0);
        bewertung1.setRatingText("default fallback");
        return bewertung1;
    }

    public List<Bewertung> reliable2(){
        return new ArrayList<Bewertung>();
    }

    public Bewertung reliable3(Long id){
        Bewertung b = new Bewertung();
        b.setRatingText("default fallback");
        return b;
    }

    public ResponseEntity<Bewertung> reliable4(Bewertung bewertung){
        return ResponseEntity.notFound().build();
    }


}
