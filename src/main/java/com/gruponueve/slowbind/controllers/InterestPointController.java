package com.gruponueve.slowbind.controllers;

import com.gruponueve.slowbind.enums.Categoria;
import com.gruponueve.slowbind.enums.Zona;
import com.gruponueve.slowbind.models.InterestPoint;
import com.gruponueve.slowbind.services.InterestPointService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class InterestPointController {

    @Autowired
    private InterestPointService interestPointService;

    @GetMapping("/interestpoints")
    public List<InterestPoint> getInterestPoints() {
        return interestPointService.getInterestPoint();
    }

    @GetMapping("/interestpoints/{id}")
    public ResponseEntity<InterestPoint> getInterestPointById(@PathVariable Integer id) {
        if (interestPointService.getInterestPointById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(interestPointService.getInterestPointById(id));
        }
    }

    @GetMapping("/interestpoints/categoria/{categoria}")
    public List<InterestPoint> getInterestPointByCategoria(@PathVariable Categoria categoria) {
        return interestPointService.getInterestPointByCategoria(categoria);
    }

    @CrossOrigin(origins = {"http://localhost:5173", "http://localhost:8081"})
    @PostMapping("/interestpoints/filters/")
    public List<InterestPoint> getInterestPointByFilters(
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String zona,
            @RequestParam(defaultValue = "100") double rating) {



        if (categoria != null && zona != null && rating != 100) {
            return interestPointService.getInterestPointByCategoriaAndZonaAndRating(
                    Categoria.valueOf(categoria), Zona.valueOf(zona), rating);
        } else if (categoria != null && zona != null) {
            return interestPointService.getInterestPointByCategoriaAndZona(
                    Categoria.valueOf(categoria), Zona.valueOf(zona));
        } else if (categoria != null && rating != 100) {
            return interestPointService.getInterestPointByCategoriaAndRating(
                    Categoria.valueOf(categoria), rating);
        } else if (zona != null  && rating != 100) {
            return interestPointService.getInterestPointByZonaAndRating(
                    Zona.valueOf(zona), rating);
        } else if (categoria != null ) {
            return interestPointService.getInterestPointByCategoria(
                    Categoria.valueOf(categoria));
        } else if (zona != null ) {
            return interestPointService.getInterestPointByZona(Zona.valueOf(zona));
        } else if (rating != 100) {
            return interestPointService.getInterestPointByRating(rating);
        } else {
            return interestPointService.getInterestPoint();
        }
    }
}
