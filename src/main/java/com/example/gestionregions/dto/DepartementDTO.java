package com.example.gestionregions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartementDTO {
    private Long id;
    private String nom;
    private String chefLieuDepartement;
    // pas de champ "region" ici : on casse le cycle à cet endroit précis
}
