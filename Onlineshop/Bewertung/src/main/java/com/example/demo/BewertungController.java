package com.example.demo;

import com.example.demo.bewertung.dao.BewertungDAO;
import com.example.demo.bewertung.model.Bewertung;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("bewertungen")
public class BewertungController {

    @Autowired
    BewertungDAO bewertungDAO;
    // save bewertung into database
    @HystrixCommand(fallbackMethod = "reliable")
    @PostMapping("/bewertungen")
    public Bewertung createBewertung(@Valid @RequestBody Bewertung bewertung){
        return bewertungDAO.save(bewertung);
    }

    //get all bewertungen
    @HystrixCommand(fallbackMethod = "reliable2")
    @GetMapping("/bewertungen")
    public List<Bewertung> getAllBewertungs(){
        return bewertungDAO.findAll();
    }

    //get bewertung by id
    @HystrixCommand(fallbackMethod = "reliable3")
    @GetMapping("/bewertungen/{id]")
    public ResponseEntity<Bewertung> getBewertungById(@PathVariable(value = "id") Long bewertungid){
        Bewertung bewertung = bewertungDAO.findOne(bewertungid);

        if(bewertung == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(bewertung);
    }

    //update an bewertung
    @PutMapping("/bewertungen/{id}")
    public ResponseEntity<Bewertung> updateBewertung(@PathVariable(value = "id") Long bewertungid,
                                                     @Valid @RequestBody Bewertung bewertungDetails){
        Bewertung bewertung = bewertungDAO.findOne(bewertungid);

        if(bewertung == null){
            return ResponseEntity.notFound().build();
        }
        bewertung.setBeschreibung(bewertungDetails.getBeschreibung());
        bewertung.setRating(bewertungDetails.getRating());

        Bewertung updateBewertung = bewertungDAO.save(bewertung);
        return ResponseEntity.ok().body(updateBewertung);
    }

    //delete an bewertung
    @DeleteMapping("/bewertungen/{id}")
    public ResponseEntity<Bewertung> deleteBewertung(@PathVariable(value = "id") Long bewertungid){

        Bewertung bewertung = bewertungDAO.findOne(bewertungid);

        if(bewertung == null){
            return ResponseEntity.notFound().build();
        }

        bewertungDAO.delete(bewertung);
        return  ResponseEntity.ok().build();
    }
}
