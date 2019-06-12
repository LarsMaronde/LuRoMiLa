package com.onlineshop.demo.jpa;

import com.onlineshop.demo.jpa.entity.Bewertung;
import org.springframework.data.repository.CrudRepository;

public interface BewertungRepository extends CrudRepository<Bewertung, Long> {

}
