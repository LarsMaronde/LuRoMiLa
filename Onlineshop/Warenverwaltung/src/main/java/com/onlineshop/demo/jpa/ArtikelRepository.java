package com.onlineshop.demo.jpa;

import com.onlineshop.demo.jpa.entity.Artikel;
import org.springframework.data.repository.CrudRepository;

public interface ArtikelRepository extends CrudRepository<Artikel, Long> {

}
