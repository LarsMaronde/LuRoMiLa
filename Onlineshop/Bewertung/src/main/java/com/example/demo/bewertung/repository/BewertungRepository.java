package com.example.demo.bewertung.repository;

import com.example.demo.bewertung.model.Bewertung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BewertungRepository extends JpaRepository<Bewertung, Long> {
}
