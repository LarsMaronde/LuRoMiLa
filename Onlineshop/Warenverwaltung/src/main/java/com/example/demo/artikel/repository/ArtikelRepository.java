package com.example.demo.artikel.repository;

import com.example.demo.artikel.model.Artikel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtikelRepository extends JpaRepository<Artikel, Long> {
}
