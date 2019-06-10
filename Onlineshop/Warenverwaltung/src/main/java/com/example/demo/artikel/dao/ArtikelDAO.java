package com.example.demo.artikel.dao;

import com.example.demo.artikel.model.Artikel;
import com.example.demo.artikel.repository.ArtikelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtikelDAO {

    @Autowired
    private ArtikelRepository repository;


    //save user
    public Artikel save(Artikel artikel){
        return repository.save(artikel);
    }

    //search all users
    public List<Artikel> findAll(){
        return repository.findAll();
    }

    //get one
    public Artikel findOne(Long aid){
        return repository.getOne(aid);
    }

    //delete an user
    public void delete(Artikel artikel){
        repository.delete(artikel);
    }


}
