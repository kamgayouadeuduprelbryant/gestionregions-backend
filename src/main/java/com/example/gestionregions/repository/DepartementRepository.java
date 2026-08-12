package com.example.gestionregions.repository;

import com.example.gestionregions.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
    // retrouver directement tous les départements d'une région précise
    List<Departement> findByRegionId(Long regionId);
}