package com.example.gestionregions.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DepartementCreateDTO {
    @NotBlank(message = "Le nom du département est obligatoire")
    private String nom;

    private String chefLieuDepartement;

    @NotNull(message = "L'id de la région est obligatoire")
    private Long regionId;
}
