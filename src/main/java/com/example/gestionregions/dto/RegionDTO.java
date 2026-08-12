package com.example.gestionregions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RegionDTO {
    private Long id;
    private String nom;
    private String chefLieu;
    private String nomGouverneur;
    private int nombreDepartements;
    private int nombreArrondissements;
    private long population;
    private double indiceRichesse;
    private LocalDateTime dateCreation;
    private LocalDateTime dateDerniereMiseAJour;
    private List<DepartementDTO> departements;
}
