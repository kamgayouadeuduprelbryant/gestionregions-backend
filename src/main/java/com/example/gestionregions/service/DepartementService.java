package com.example.gestionregions.service;

import com.example.gestionregions.dto.DepartementCreateDTO;
import com.example.gestionregions.dto.DepartementDTO;
import com.example.gestionregions.entity.Departement;
import com.example.gestionregions.entity.Region;
import com.example.gestionregions.exception.RegionNotFoundException;
import com.example.gestionregions.mapper.DepartementMapper;
import com.example.gestionregions.repository.DepartementRepository;
import com.example.gestionregions.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartementService {

    private final DepartementRepository departementRepository;
    private final RegionRepository regionRepository;
    private final DepartementMapper departementMapper;

    public DepartementService(DepartementRepository departementRepository,
                              RegionRepository regionRepository,
                              DepartementMapper departementMapper) {
        this.departementRepository = departementRepository;
        this.regionRepository = regionRepository;
        this.departementMapper = departementMapper;
    }

    public DepartementDTO ajouterDepartement(DepartementCreateDTO dto) {

        Region region = regionRepository.findById(dto.getRegionId())
                .orElseThrow(() -> new RegionNotFoundException(dto.getRegionId()));

        Departement departement = new Departement();

        departement.setNom(dto.getNom());
        departement.setChefLieuDepartement(dto.getChefLieuDepartement());
        departement.setRegion(region);

        Departement enregistre = departementRepository.save(departement);

        return departementMapper.toDTO(enregistre);
    }

    // Récupérer TOUS les départements
    public List<DepartementDTO> listerDepartements() {

        return departementRepository.findAll()
                .stream()
                .map(departementMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Récupérer les départements d'une région
    public List<DepartementDTO> listerDepartementsDeLaRegion(Long regionId) {

        if (!regionRepository.existsById(regionId)) {
            throw new RegionNotFoundException(regionId);
        }

        return departementRepository.findByRegionId(regionId)
                .stream()
                .map(departementMapper::toDTO)
                .collect(Collectors.toList());
    }
    public DepartementDTO modifierDepartement(Long id, DepartementCreateDTO dto) {

        Departement departement = departementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Département introuvable"));

        Region region = regionRepository.findById(dto.getRegionId())
                .orElseThrow(() -> new RegionNotFoundException(dto.getRegionId()));

        departement.setNom(dto.getNom());
        departement.setChefLieuDepartement(dto.getChefLieuDepartement());
        departement.setRegion(region);

        Departement modifie = departementRepository.save(departement);

        return departementMapper.toDTO(modifie);
    }
    public void supprimerDepartement(Long id) {

        Departement departement = departementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Département introuvable"));

        departementRepository.delete(departement);
    }
}