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

    @PostMapping("/interestpoints/filters/")
    public List<InterestPoint> getInterestPointByFilters(@ModelAttribute String categoria, @ModelAttribute String zona, @ModelAttribute String rating) {
        if (!categoria.isBlank() && !zona.isBlank() && !rating.isBlank()){
            return interestPointService.getInterestPointByCategoriaAndZonaAndRating(Categoria.valueOf(categoria), Zona.valueOf(zona), Double.valueOf(rating));
        } else if (!categoria.isBlank() && !zona.isBlank()){
            return interestPointService.getInterestPointByCategoriaAndZona(Categoria.valueOf(categoria), Zona.valueOf(zona));
        } else if (!categoria.isBlank() && !rating.isBlank()){
            return interestPointService.getInterestPointByCategoriaAndRating(Categoria.valueOf(categoria), Double.valueOf(rating));
        } else if (!zona.isBlank() && !rating.isBlank()){
            return interestPointService.getInterestPointByZonaAndRating(Zona.valueOf(zona), Double.valueOf(rating));
        } else if (!categoria.isBlank()){
            return interestPointService.getInterestPointByCategoria(Categoria.valueOf(categoria));
        } else if (!zona.isBlank()){
            return interestPointService.getInterestPointByZona(Zona.valueOf(zona));
        } else if (!rating.isBlank()){
            return interestPointService.getInterestPointByRating(Double.valueOf(rating));
        } else {
            return interestPointService.getInterestPoint();
        }
    }
}
