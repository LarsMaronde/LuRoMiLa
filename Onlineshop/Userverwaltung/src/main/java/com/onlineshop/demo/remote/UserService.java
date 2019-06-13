package com.onlineshop.demo.remote;

import com.onlineshop.demo.jpa.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> findAll();

    User findOne(Long uid);

    void delete(User user);

    ResponseEntity<User> updateUser(User user);

    //synch rest call to Warenverwaltung service
    int getBestand(Long artikelid);

    //one-way call to Bewertung service
    void rateArtikel (Long artikelid, Long userid, int rating, String beschreibung);

}
