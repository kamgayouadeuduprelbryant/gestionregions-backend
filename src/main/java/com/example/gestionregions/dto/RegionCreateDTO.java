package com.example.gestionregions.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RegionCreateDTO {
    @NotBlank(message = "Le nom de la région est obligatoire")
    private String nom;

    @NotBlank(message = "Le chef-lieu est obligatoire")
    private String chefLieu;

    @NotBlank(message = "Le nom du gouverneur est obligatoire")
    private String nomGouverneur;

    @Min(value = 1, message = "Une région doit avoir au moins 1 département")
    private int nombreDepartements;

    @Min(value = 1, message = "Une région doit avoir au moins 1 arrondissement")
    private int nombreArrondissements;

    @Positive(message = "La population doit être un nombre positif")
    private long population;

    @Positive(message = "L'indice de richesse doit être un nombre positif")
    private double indiceRichesse;
}
