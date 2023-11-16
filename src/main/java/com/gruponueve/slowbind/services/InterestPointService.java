package com.gruponueve.slowbind.services;

import com.gruponueve.slowbind.dtos.InterestPointResponseDTO;
import com.gruponueve.slowbind.enums.Categoria;
import com.gruponueve.slowbind.enums.Zona;
import com.gruponueve.slowbind.models.InterestPoint;
import com.gruponueve.slowbind.repository.IInterestPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class InterestPointService implements InterfaceInterestPointService {

    @Autowired
    GoogleApiService googleApiService;

    @Autowired
    private IInterestPointRepository interestPointRepository;

    @Override
    public List<InterestPoint> getInterestPoint() {
        return interestPointRepository.findAll();
    }

    @Override
    public InterestPoint getInterestPointById(Integer id) {
        return interestPointRepository.findById(id).get();
    }

    @Override
    public InterestPoint saveInterestPoint(InterestPoint interestPoint) {
        return interestPointRepository.save(interestPoint);
    }

    @Override
    public List<InterestPoint> saveInterestPoints(List<InterestPoint> interestPoints) {
        return interestPointRepository.saveAll(interestPoints);
    }

    @Override
    public InterestPoint updateInterestPoint(InterestPoint skin) {
        return interestPointRepository.save(skin);
    }

    @Override
    public void deleteInterestPointById(Integer id) {
        interestPointRepository.deleteById(id);
    }

    @Override
    public List<InterestPoint> getInterestPointByCategoria(Categoria categoria) {
        return interestPointRepository.findByCategoria(categoria);
    }


    @Override
    public List<InterestPoint> getInterestPointByRating(Double rating) {
        return interestPointRepository.findByRatingGreaterThanEqual(rating);
    }

    @Override
    public List<InterestPoint> getInterestPointByZona(Zona zona) {
        return interestPointRepository.findByZona(zona);
    }

    @Override
    public List<InterestPoint> getInterestPointByName(String name) {
        return interestPointRepository.findByNameContains(name);
    }

    @Override
    public List<InterestPoint> getInterestPointByCategoriaAndZona(Categoria categoria, Zona zona) {
        return interestPointRepository.findByCategoriaAndZona(categoria, zona);
    }

    @Override
    public List<InterestPoint> getInterestPointByCategoriaAndRating(Categoria categoria, Double rating) {
        return interestPointRepository.findByRatingGreaterThanEqualAndCategoria(rating, categoria);
    }

    @Override
    public List<InterestPoint> getInterestPointByZonaAndRating(Zona zona, Double rating) {
        return interestPointRepository.findByRatingGreaterThanEqualAndZona(rating, zona);
    }

    @Override
    public List<InterestPoint> getInterestPointByCategoriaAndZonaAndRating(Categoria categoria, Zona zona, Double rating) {
        return interestPointRepository.findByRatingGreaterThanEqualAndCategoriaAndZona(rating, categoria, zona);
    }


    public InterestPointResponseDTO findWithGoogleDetails(Integer id) throws IOException {
        InterestPoint newInterestPoint = getInterestPointById(id);

        InterestPointResponseDTO InterestPointResponseDTO =
                googleApiService.getMonumentInfo(newInterestPoint.getLatitud(), newInterestPoint.getLongitud());

        return InterestPointResponseDTO;
    }



}
