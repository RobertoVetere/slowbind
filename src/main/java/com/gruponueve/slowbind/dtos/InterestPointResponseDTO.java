package com.gruponueve.slowbind.dtos;


import com.gruponueve.slowbind.enums.Zona;
import com.gruponueve.slowbind.models.InterestPoint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class InterestPointResponseDTO {
    private String name;
    private String description;
    private Double rating;
    private Zona zona;
    private String imageReference;

    public InterestPointResponseDTO (InterestPoint interestPoint, String description, String imageReference) {
        this.name= interestPoint.getName();
        this.zona= interestPoint.getZona();
        this.rating= interestPoint.getRating();
        this.description=description;
        this.imageReference=imageReference;

    }

}
