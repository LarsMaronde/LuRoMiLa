package com.onlineshop.demo.jpa;

import com.onlineshop.demo.jpa.entity.Artikel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ArtikelRepository extends CrudRepository<Artikel, Long> {

    Artikel findArtikelByName(@Param("name") String name);
}
