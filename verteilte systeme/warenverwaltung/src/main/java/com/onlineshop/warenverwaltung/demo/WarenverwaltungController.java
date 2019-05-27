package com.onlineshop.warenverwaltung.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarenverwaltungController {

    @RequestMapping("/warenkorb")
    public String hello() {
        return "warenkorb";
    }


}
