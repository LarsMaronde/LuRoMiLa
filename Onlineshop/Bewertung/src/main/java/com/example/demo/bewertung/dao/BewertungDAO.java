package com.example.demo.bewertung.dao;

import com.example.demo.bewertung.model.Bewertung;
import com.example.demo.bewertung.repository.BewertungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BewertungDAO {

    @Autowired
    private BewertungRepository repository;


    //save bewertung
    public Bewertung save(Bewertung bewertung){
        return repository.save(bewertung);
    }

    //search all bewertungen
    public List<Bewertung> findAll(){
        return repository.findAll();
    }

    //get one
    public Bewertung findOne(Long bid){
        return repository.getOne(bid);
    }

    //delete bewertung
    public void delete(Bewertung bewertung){
        repository.delete(bewertung);
    }



}
