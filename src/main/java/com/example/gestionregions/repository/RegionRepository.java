package com.example.gestionregions.repository;

import com.example.gestionregions.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {
    List<Region> findAllByOrderByIndiceRichesseDesc();

    List<Region> findAllByOrderByPopulationDesc();
}