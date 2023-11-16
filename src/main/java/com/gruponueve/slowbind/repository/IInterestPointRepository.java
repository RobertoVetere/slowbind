package com.gruponueve.slowbind.repository;

import com.gruponueve.slowbind.enums.Categoria;
import com.gruponueve.slowbind.enums.Zona;
import com.gruponueve.slowbind.models.InterestPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInterestPointRepository extends JpaRepository<InterestPoint, Integer> {

    @Query("select i from InterestPoint i where i.name like concat('%', ?1, '%')")
    List<InterestPoint> findByNameContains(String name);

    @Query("select i from InterestPoint i where i.categoria = ?1")
    List<InterestPoint> findByCategoria(Categoria categoria);

    @Query("select i from InterestPoint i where i.index >= ?1")
    List<InterestPoint> findByIndexGreaterThanEqual(double index);

    @Query("select i from InterestPoint i where i.zona = ?1")
    List<InterestPoint> findByZona(Zona zona);

}
