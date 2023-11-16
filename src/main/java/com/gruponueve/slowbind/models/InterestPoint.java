package com.gruponueve.slowbind.models;

import com.gruponueve.slowbind.enums.Categoria;
import com.gruponueve.slowbind.enums.Zona;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "interest_points")
@Data
public class InterestPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Categoria category;

    private Double rating;

    private Zona zone;

    private double longitude;

    private double latitude;

    private String address;

}
