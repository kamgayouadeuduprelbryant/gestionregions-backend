package com.example.gestionregions.service;

import com.example.gestionregions.dto.RegionCreateDTO;
import com.example.gestionregions.dto.RegionDTO;
import com.example.gestionregions.entity.Region;
import com.example.gestionregions.exception.RegionNotFoundException;
import com.example.gestionregions.mapper.RegionMapper;
import com.example.gestionregions.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class RegionService {
    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;

    public RegionService(RegionRepository regionRepository, RegionMapper regionMapper) {
        this.regionRepository = regionRepository;
        this.regionMapper = regionMapper;
    }

    public List<RegionDTO> getToutesLesRegions() {
        return regionRepository.findAll()
                .stream()
                .map(regionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RegionDTO getRegionParId(Long id) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new RegionNotFoundException(id));
        return regionMapper.toDTO(region);
    }

    public RegionDTO creerRegion(RegionCreateDTO dto) {
        Region region = regionMapper.toEntity(dto);
        Region regionEnregistree = regionRepository.save(region);
        return regionMapper.toDTO(regionEnregistree);
    }

    public RegionDTO modifierRegion(Long id, RegionCreateDTO dto) {
        Region regionExistante = regionRepository.findById(id)
                .orElseThrow(() -> new RegionNotFoundException(id));

        regionExistante.setNom(dto.getNom());
        regionExistante.setChefLieu(dto.getChefLieu());
        regionExistante.setNomGouverneur(dto.getNomGouverneur());
        regionExistante.setNombreDepartements(dto.getNombreDepartements());
        regionExistante.setNombreArrondissements(dto.getNombreArrondissements());
        regionExistante.setPopulation(dto.getPopulation());
        regionExistante.setIndiceRichesse(dto.getIndiceRichesse());
        // dateDerniereMiseAJour : recalculée automatiquement par @UpdateTimestamp

        Region regionMiseAJour = regionRepository.save(regionExistante);
        return regionMapper.toDTO(regionMiseAJour);
    }

    public void supprimerRegion(Long id) {
        if (!regionRepository.existsById(id)) {
            throw new RegionNotFoundException(id);
        }
        regionRepository.deleteById(id);
    }

    public List<RegionDTO> classerParRichesse() {
        return regionRepository.findAllByOrderByIndiceRichesseDesc()
                .stream()
                .map(regionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RegionDTO getRegionLaPlusPeuplee() {
        return regionRepository.findAllByOrderByPopulationDesc()
                .stream()
                .findFirst()
                .map(regionMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Aucune région enregistrée"));
    }


}
