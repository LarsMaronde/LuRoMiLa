package com.onlineshop.warenverwaltung.demo;

import com.onlineshop.warenverwaltung.demo.Produkt.Model.Produkt;
import com.onlineshop.warenverwaltung.demo.Produkt.Repository.ProduktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarenverwaltungController {


    @Autowired
    private ProduktRepository produktRepo;


    @RequestMapping("/warenkorb")
    public String hello() {
        return "warenkorb";
    }


}
