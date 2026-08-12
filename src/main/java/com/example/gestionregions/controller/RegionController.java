package com.example.gestionregions.controller;

import com.example.gestionregions.dto.RegionCreateDTO;
import com.example.gestionregions.dto.RegionDTO;
import com.example.gestionregions.entity.Region;
import com.example.gestionregions.service.RegionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;

// renvoie du JSON, pas des pages HTML
@RestController
// préfixe commun à tous les endpoints de cette classe
@RequestMapping("/api/regions")
@CrossOrigin(origins =  "http://localhost:4200/")

public class RegionController {
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    public ResponseEntity<List<RegionDTO>> getToutesLesRegions() {
        return ResponseEntity.ok(regionService.getToutesLesRegions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionDTO> getRegionParId(@PathVariable Long id) {
        return ResponseEntity.ok(regionService.getRegionParId(id));
    }

    @PostMapping
    public ResponseEntity<RegionDTO> creerRegion(@Valid @RequestBody RegionCreateDTO dto) {
        RegionDTO regionCreee = regionService.creerRegion(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(regionCreee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegionDTO> modifierRegion(@PathVariable Long id, @Valid @RequestBody RegionCreateDTO dto) {
        return ResponseEntity.ok(regionService.modifierRegion(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerRegion(@PathVariable Long id) {
        regionService.supprimerRegion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/classement-richesse")
    public ResponseEntity<List<RegionDTO>> classerParRichesse() {
        return ResponseEntity.ok(regionService.classerParRichesse());
    }

    @GetMapping("/plus-peuplee")
    public ResponseEntity<RegionDTO> getRegionLaPlusPeuplee() {
        return ResponseEntity.ok(regionService.getRegionLaPlusPeuplee());
    }
}
