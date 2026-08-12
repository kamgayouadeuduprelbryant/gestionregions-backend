package com.example.gestionregions.entity;

import jakarta.persistence.ManyToMany;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class Cours {
    @ManyToMany(mappedBy = "cours")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Etudiant> etudiants = new ArrayList<>();
}
