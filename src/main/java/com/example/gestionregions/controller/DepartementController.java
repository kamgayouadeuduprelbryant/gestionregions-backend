package com.example.gestionregions.controller;

import com.example.gestionregions.dto.DepartementCreateDTO;
import com.example.gestionregions.dto.DepartementDTO;
import com.example.gestionregions.service.DepartementService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departements")
@CrossOrigin(origins =  "http://localhost:4200/")
public class DepartementController {

    private final DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    // POST : créer un département
    @PostMapping
    public ResponseEntity<DepartementDTO> ajouterDepartement(
            @Valid @RequestBody DepartementCreateDTO dto) {

        DepartementDTO cree = departementService.ajouterDepartement(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cree);
    }

    // GET : récupérer tous les départements
    @GetMapping
    public ResponseEntity<List<DepartementDTO>> listerDepartements() {

        return ResponseEntity.ok(
                departementService.listerDepartements()
        );
    }

    // GET : récupérer les départements d'une région
    @GetMapping("/region/{regionId}")
    public ResponseEntity<List<DepartementDTO>> listerDepartementsDeLaRegion(
            @PathVariable Long regionId) {

        return ResponseEntity.ok(
                departementService.listerDepartementsDeLaRegion(regionId)
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<DepartementDTO> modifierDepartement(
            @PathVariable Long id,
            @Valid @RequestBody DepartementCreateDTO dto) {

        DepartementDTO modifie = departementService.modifierDepartement(id, dto);

        return ResponseEntity.ok(modifie);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerDepartement(@PathVariable Long id) {

        departementService.supprimerDepartement(id);

        return ResponseEntity.noContent().build();
    }
}