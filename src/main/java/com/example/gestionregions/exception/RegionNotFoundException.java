package com.example.gestionregions.exception;

public class RegionNotFoundException extends RuntimeException{
    public RegionNotFoundException(Long id){
        super("Region introuvable avec l'id" + id);
    }
}
