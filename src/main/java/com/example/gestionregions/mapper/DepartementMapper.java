package com.example.gestionregions.mapper;

import com.example.gestionregions.dto.DepartementDTO;
import com.example.gestionregions.entity.Departement;
import org.springframework.stereotype.Component;

@Component
public class DepartementMapper {
    public DepartementDTO toDTO(Departement departement) {
        DepartementDTO dto = new DepartementDTO();
        dto.setId(departement.getId());
        dto.setNom(departement.getNom());
        dto.setChefLieuDepartement(departement.getChefLieuDepartement());
        return dto;
    }
}
