package com.onlineshop.warenverwaltung.demo.Produkt.Repository;

import com.onlineshop.warenverwaltung.demo.Produkt.Model.Produkt;
import org.springframework.data.repository.CrudRepository;

public interface ProduktRepository extends CrudRepository<Produkt, Integer> {

    Produkt findByProduktId(int id);
}
