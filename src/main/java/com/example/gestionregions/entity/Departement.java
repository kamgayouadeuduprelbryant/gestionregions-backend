package com.example.gestionregions.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du département est obligatoire")
    private String nom;
    private String chefLieuDepartement;

    // côté qui porte la colonne étrangère : celui dont le maximum vaut 1
    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    @ToString.Exclude              // voir Partie 1, point 7 : casse le cycle au niveau de toString()
    @EqualsAndHashCode.Exclude     // casse le cycle au niveau de equals()/hashCode()
    private Region region;
}
