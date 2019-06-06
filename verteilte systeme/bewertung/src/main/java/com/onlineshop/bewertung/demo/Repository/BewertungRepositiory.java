package com.onlineshop.bewertung.demo.Repository;


import com.onlineshop.bewertung.demo.model.Bewertung;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

public interface BewertungRepositiory extends CrudRepository<User, Integer> {

    Bewertung findByBewertungsId(int id);

}
