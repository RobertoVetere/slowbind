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

    @Query("select i from InterestPoint i where i.rating >= ?1")
    List<InterestPoint> findByRatingGreaterThanEqual(double rating);

    @Query("select i from InterestPoint i where i.categoria = ?1 and i.zona = ?2")
    List<InterestPoint> findByCategoriaAndZona(Categoria categoria, Zona zona);

    @Query("select i from InterestPoint i where i.rating >= ?1 and i.zona = ?2")
    List<InterestPoint> findByRatingGreaterThanEqualAndZona(Double rating, Zona zona);

    @Query("select i from InterestPoint i where i.rating >= ?1 and i.categoria = ?2")
    List<InterestPoint> findByRatingGreaterThanEqualAndCategoria(Double rating, Categoria categoria);



    @Query("select i from InterestPoint i where i.rating >= ?1 and i.categoria = ?2 and i.zona = ?3")
    List<InterestPoint> findByRatingGreaterThanEqualAndCategoriaAndZona(Double rating, Categoria categoria, Zona zona);



    @Query("select i from InterestPoint i where i.zona = ?1")
    List<InterestPoint> findByZona(Zona zona);

}
