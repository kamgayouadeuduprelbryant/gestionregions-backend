package com.example.gestionregions.seed;

import com.example.gestionregions.entity.Region;
import com.example.gestionregions.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class DataSeeder implements CommandLineRunner {
    private final RegionRepository regionRepository;

    public DataSeeder(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
}
    @Override
    public void run(String... args) {

        if (regionRepository.count() > 0) {
            return;
        }
        regionRepository.save(Region.builder()
                .nom("Adamaoua")
                .chefLieu("Ngaoundéré")
                .nomGouverneur("Nom fictif")
                .nombreDepartements(5)
                .nombreArrondissements(21)
                .population(1_200_000)
                .indiceRichesse(0.45)
                .build());

        regionRepository.save(Region.builder()
                .nom("Centre")
                .chefLieu("Yaoundé")
                .nomGouverneur("Nom fictif")
                .nombreDepartements(10)
                .nombreArrondissements(70)
                .population(5_000_000)
                .indiceRichesse(0.72)
                .build());

        regionRepository.save(Region.builder()
                .nom("Est")
                .chefLieu("Bertoua")
                .nomGouverneur("Nom fictif")
                .nombreDepartements(4)
                .nombreArrondissements(32)
                .population(900_000)
                .indiceRichesse(0.38)
                .build());

        regionRepository.save(Region.builder()
                .nom("Extrême-Nord")
                .chefLieu("Maroua")
                .nomGouverneur("Nom fictif")
                .nombreDepartements(6)
                .nombreArrondissements(46)
                .population(4_200_000)
                .indiceRichesse(0.30)
                .build());

        regionRepository.save(Region.builder()
                .nom("Littoral")
                .chefLieu("Douala")
                .nomGouverneur("Nom fictif")
                .nombreDepartements(4)
                .nombreArrondissements(27)
                .population(3_700_000)
                .indiceRichesse(0.80)
                .build());

        regionRepository.save(Region.builder()
                .nom("Nord")
                .chefLieu("Garoua")
                .nomGouverneur("Nom fictif")
                .nombreDepartements(4)
                .nombreArrondissements(21)
                .population(2_700_000)
                .indiceRichesse(0.35)
                .build());

        regionRepository.save(Region.builder()
                .nom("Nord-Ouest")
                .chefLieu("Bamenda")
                .nomGouverneur("Nom fictif")
                .nombreDepartements(7)
                .nombreArrondissements(34)
                .population(2_000_000)
                .indiceRichesse(0.42)
                .build());

        regionRepository.save(Region.builder()
                .nom("Ouest")
                .chefLieu("Bafoussam")
                .nomGouverneur("Nom fictif")
                .nombreDepartements(8)
                .nombreArrondissements(40)
                .population(2_000_000)
                .indiceRichesse(0.55)
                .build());

        regionRepository.save(Region.builder()
                .nom("Sud")
                .chefLieu("Ebolowa")
                .nomGouverneur("Nom fictif")
                .nombreDepartements(4)
                .nombreArrondissements(33)
                .population(800_000)
                .indiceRichesse(0.40)
                .build());

        regionRepository.save(Region.builder()
                .nom("Sud-Ouest")
                .chefLieu("Buéa")
                .nomGouverneur("Nom fictif")
                .nombreDepartements(6)
                .nombreArrondissements(32)
                .population(1_600_000)
                .indiceRichesse(0.50)
                .build());
    }
}