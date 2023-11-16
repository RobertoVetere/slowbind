package com.gruponueve.slowbind.dto;

import com.gruponueve.slowbind.enums.Categoria;
import com.gruponueve.slowbind.enums.Zona;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class InterestPointDTO {

    private int id;
    private String name;
    private Categoria categoria;
    private Double rating;
    private Zona zona;
    private double longitud;
    private double latitud;
    private String description;
    private List<String> photoReference; // Nuevo campo para referencias de fotos

    // Constructor privado para el builder

    public InterestPointDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPhotoReference() {
        return photoReference;
    }

    public void setPhotoReference(List<String> photoReference) {
        this.photoReference = photoReference;
    }
}

