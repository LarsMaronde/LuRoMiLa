package com.onlineshop.demo.remote.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("Warenverwaltung-service")
public interface WarenverwaltungClient {

    @GetMapping("users/bestand/{id}")
    int getBestand(@PathVariable(value = "id") Long artikelid);

}
