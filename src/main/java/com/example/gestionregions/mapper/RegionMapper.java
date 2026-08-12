package com.example.gestionregions.mapper;

import com.example.gestionregions.dto.RegionCreateDTO;
import com.example.gestionregions.dto.RegionDTO;
import com.example.gestionregions.entity.Region;
import org.springframework.stereotype.Component;

@Component

public class RegionMapper {
    // Entity -> DTO : utilisé pour toutes les lectures (GET)
    public RegionDTO toDTO(Region region) {
        RegionDTO dto = new RegionDTO();
        dto.setId(region.getId());
        dto.setNom(region.getNom());
        dto.setChefLieu(region.getChefLieu());
        dto.setNomGouverneur(region.getNomGouverneur());
        dto.setNombreDepartements(region.getNombreDepartements());
        dto.setNombreArrondissements(region.getNombreArrondissements());
        dto.setPopulation(region.getPopulation());
        dto.setIndiceRichesse(region.getIndiceRichesse());
        dto.setDateCreation(region.getDateCreation());
        dto.setDateDerniereMiseAJour(region.getDateDerniereMiseAJour());
        return dto;
    }

    // DTO -> Entity : utilisé à la création (POST)
    public Region toEntity(RegionCreateDTO dto) {
        Region region = new Region();
        region.setNom(dto.getNom());
        region.setChefLieu(dto.getChefLieu());
        region.setNomGouverneur(dto.getNomGouverneur());
        region.setNombreDepartements(dto.getNombreDepartements());
        region.setNombreArrondissements(dto.getNombreArrondissements());
        region.setPopulation(dto.getPopulation());
        region.setIndiceRichesse(dto.getIndiceRichesse());
        // pas d'id, pas de dates : générés automatiquement (voir section 7)
        return region;
    }
}
