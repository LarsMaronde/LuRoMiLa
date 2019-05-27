package com.onlineshop.userverwaltung.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserverwaltungController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello cloudy world";
    }
}
