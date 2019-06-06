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
    @ResponseBody
    @RequestMapping("/delete")
    public String delete(int id){
        try {
            produktRepo.deleteById(id);
        } catch (Exception e) {
            return "Error beim Löschen des Produktes:" + e.toString();
        }
        return "Produkt wurde erfolgreich gelöscht!";
    }
    @ResponseBody
    @RequestMapping("get-by-id")
    public String getByEmail(int id) {
        String userId = "";
        try {
            Produkt produkt = produktRepo.findByProduktId(id);
            userId = String.valueOf(produkt.getArtikelnummer());
        }
        catch (Exception ex) {
            return "Produkt wurde nicht gefunden";
        }
        return "Die Produkt Artikelnummer ist: " + userId;
    }

    @ResponseBody
    @RequestMapping("/update")
    public String updateUser(String name, int id, float Preis){
        try{
            Produkt produkt = produktRepo.findByProduktId(id);
            produkt.setPreis(Preis);
            produkt.setName(name);
            produkt.setArtikelnummer(id);
            produktRepo.save(produkt);

        }catch(Exception e){
            return "Error beim Aktualisieren"+e.toString();
        }
        return "Produkt wurde erfolgreich aktualisiert";
    }

}
