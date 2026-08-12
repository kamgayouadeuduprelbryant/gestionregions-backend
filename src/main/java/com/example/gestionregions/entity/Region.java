package com.example.gestionregions.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="regions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nom;
    @NonNull
    private String chefLieu;

    @NonNull
    private String nomGouverneur;



    private int nombreDepartements;


    private int nombreArrondissements;


    private long population;


    private double indiceRichesse;
    // Hibernate remplit ce champ automatiquement, une seule fois, à la création
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dateCreation;

    // Hibernate remplit ce champ automatiquement à CHAQUE modification
    @UpdateTimestamp
    private LocalDateTime dateDerniereMiseAJour;

    @OneToOne
    @JoinColumn(name = "gouverneur_id")
    private Gouverneur gouverneur;

    // côté inverse : ne porte rien, pointe vers le champ "region" de Departement
    @OneToMany(mappedBy = "region")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Departement> departements = new ArrayList<>();
     }


