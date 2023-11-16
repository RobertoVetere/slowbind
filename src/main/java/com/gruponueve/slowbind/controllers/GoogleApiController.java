package com.gruponueve.slowbind.controllers;

import com.gruponueve.slowbind.dtos.InterestPointResponseDTO;
import com.gruponueve.slowbind.services.GoogleApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/google")
public class GoogleApiController {

    @Autowired
    private GoogleApiService googleApiService;

    @GetMapping("/monument")
    public InterestPointResponseDTO getMonumentInfo(@RequestParam double latitude, @RequestParam double longitude) throws IOException {
        return googleApiService.getMonumentInfo(latitude, longitude);
    }

}