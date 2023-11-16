package com.gruponueve.slowbind.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gruponueve.slowbind.dto.InterestPointDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class GoogleApiService {
    private static final String PLACES_API_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";

    private static final String API_KEY = "AIzaSyCEU1ntFknOSngfwaHYwT00STaUDpA_nEY";

    public InterestPointDTO getMonumentInfo(double latitude, double longitude) throws IOException {

        String url = PLACES_API_URL + "?location=" + latitude + "," + longitude +
                "&radius=500&types=monument&key=" + API_KEY;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response);

        // Extraer información del primer resultado de la búsqueda
        JsonNode firstResult = root.path("results").get(0);

        String description = firstResult.path("name").asText();
        String placeId = firstResult.path("place_id").asText();

        // Obtener detalles del lugar usando el place_id
        String detailsUrl = "https://maps.googleapis.com/maps/api/place/details/json?placeid=" + placeId + "&key=" + API_KEY;
        String detailsResponse = restTemplate.getForObject(detailsUrl, String.class);

        JsonNode detailsRoot = mapper.readTree(detailsResponse);
        JsonNode detailsResult = detailsRoot.path("result");

        List<String> photoReferences = new ArrayList<>();
        if (detailsResult.has("photos")) {
            JsonNode photos = detailsResult.path("photos");
            for (JsonNode photo : photos) {
                String photoReference = photo.path("photo_reference").asText();
                photoReferences.add(photoReference);
            }
        }

        // Crear un objeto MonumentInfo con la descripción y las referencias de las fotos
        InterestPointDTO interestPointDTO = new InterestPointDTO();
        interestPointDTO.setDescription(description);
        interestPointDTO.setPhotoReference(photoReferences);

        return interestPointDTO;
    }
}