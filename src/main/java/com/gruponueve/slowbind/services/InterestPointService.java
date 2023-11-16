package com.gruponueve.slowbind.services;

import com.gruponueve.slowbind.enums.Categoria;
import com.gruponueve.slowbind.enums.Zona;
import com.gruponueve.slowbind.models.InterestPoint;
import com.gruponueve.slowbind.repository.IInterestPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestPointService implements IInterestPointService {

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
    public List<InterestPoint> getInterestPointByIndex(Double index) {
        return interestPointRepository.findByIndexGreaterThanEqual(index);
    }

    @Override
    public List<InterestPoint> getInterestPointByZona(Zona zona) {
        return interestPointRepository.findByZona(zona);
    }
}
