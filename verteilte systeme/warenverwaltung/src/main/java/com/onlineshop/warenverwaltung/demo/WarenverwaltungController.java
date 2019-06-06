package com.onlineshop.warenverwaltung.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarenverwaltungController {


    private final Produkt produkt;

    public WarenverwaltungController(Produkt produkt) {
        this.produkt = produkt;
    }

    @RequestMapping("/warenkorb")
    public String hello() {
        return "warenkorb";
    }


}
