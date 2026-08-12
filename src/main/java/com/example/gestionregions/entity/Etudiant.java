package com.example.gestionregions.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    @ManyToMany
    @JoinTable(
            name = "inscriptions",                                // nom de la table intermédiaire
            joinColumns = @JoinColumn(name = "etudiant_id"),        // colonne qui pointe vers Etudiant
            inverseJoinColumns = @JoinColumn(name = "cours_id")     // colonne qui pointe vers Cours
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Cours> cours = new ArrayList<>();
}
