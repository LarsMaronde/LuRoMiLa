package com.onlineshop.bewertung.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BewertungController {


    @RequestMapping("/bewertung")
    public String hello() {
        return "bewertungsservice";
    }
}
