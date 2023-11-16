package com.gruponueve.slowbind.services;

import com.gruponueve.slowbind.enums.Categoria;
import com.gruponueve.slowbind.enums.Zona;
import com.gruponueve.slowbind.models.InterestPoint;

import java.util.List;

public interface IInterestPointService {

    List<InterestPoint> getInterestPoint();

    InterestPoint getInterestPointById(Integer id);

    InterestPoint saveInterestPoint(InterestPoint skin);

    List<InterestPoint> saveInterestPoints(List<InterestPoint> skins);

    InterestPoint updateInterestPoint(InterestPoint skin);

    void deleteInterestPointById(Integer id);

    List<InterestPoint> getInterestPointByCategoria(Categoria categoria);

    List<InterestPoint> getInterestPointByIndex(Double index);

    List<InterestPoint> getInterestPointByZona(Zona zona);


}
