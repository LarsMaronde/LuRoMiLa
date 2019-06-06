package com.onlineshop.warenverwaltung.demo;

import com.onlineshop.warenverwaltung.demo.Produkt.Model.Produkt;
import com.onlineshop.warenverwaltung.demo.Produkt.Repository.ProduktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarenverwaltungController {


    @Autowired
    private ProduktRepository produktRepo;


    @RequestMapping("/warenkorb")
    public String hello() {
        return "warenkorb";
    }

    @RequestMapping("/error")
    public String error() {
        return "fuck you";
    }

    @ResponseBody
    @RequestMapping("/create")
    public String create(String name, int artikelnummer, float preis){
        String id ="";
        try{
            Produkt produkt = new Produkt(name, artikelnummer, preis);
            produktRepo.save(produkt);
            id =  String.valueOf(produkt.getArtikelnummer());
        }catch(Exception e){
            return "Error creating the Produkt: " + e.toString();
        }
        return "Produkt succesfully created with id = " + id;

    }

}
