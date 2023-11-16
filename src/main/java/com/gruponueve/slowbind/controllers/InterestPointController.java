package com.gruponueve.slowbind.controllers;

import com.gruponueve.slowbind.enums.Categoria;
import com.gruponueve.slowbind.enums.Zona;
import com.gruponueve.slowbind.models.InterestPoint;
import com.gruponueve.slowbind.services.InterestPointService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<InterestPoint> getInterestPointById(@ModelAttribute Integer id) {
        if (interestPointService.getInterestPointById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(interestPointService.getInterestPointById(id));
        }
    }

    @GetMapping("/interestpoints/categoria/{categoria}")
    public List<InterestPoint> getInterestPointByCategoria(@ModelAttribute Categoria categoria) {
        return interestPointService.getInterestPointByCategoria(categoria);
    }

    @GetMapping("/interestpoints/rating/{rating}")
    public List<InterestPoint> getInterestPointByRating(@ModelAttribute Double rating) {
        return interestPointService.getInterestPointByRating(rating);
    }

    @GetMapping("/interestpoints/zona/{zona}")
    public List<InterestPoint> getInterestPointByZona(@ModelAttribute Zona zona) {
        return interestPointService.getInterestPointByZona(zona);
    }

    @GetMapping("/interestpoints/name/{name}")
    public List<InterestPoint> getInterestPointByName(@ModelAttribute String name) {
        return interestPointService.getInterestPointByName(name);
    }
}
