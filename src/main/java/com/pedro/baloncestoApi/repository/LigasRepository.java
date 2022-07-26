package com.pedro.baloncestoApi.repository;

import com.pedro.baloncestoApi.model.Liga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigasRepository extends JpaRepository<Liga, Integer> {
    List<Liga> findByNombre(String nombre);

    List<Liga> findByUbicacion(String ubicacion);
}
