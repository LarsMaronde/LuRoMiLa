package com.onlineshop.demo.remote.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("Bewertung-service")
public interface BewertungClient {

    @PostMapping("users/bewertung/{artikelid}/{userid}/{rating}/{beschreibung}")
    void rateArtikel(@PathVariable(value = "artikelid") Long artikelid,
                     @PathVariable(value = "userid") Long userid,
                     @PathVariable(value = "rating") int rating,
                     @PathVariable(value = "beschreibung") String beschreibung);

}
