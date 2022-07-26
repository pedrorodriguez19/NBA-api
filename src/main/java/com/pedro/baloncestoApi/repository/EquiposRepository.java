package com.pedro.baloncestoApi.repository;

import com.pedro.baloncestoApi.model.Equipo;
import com.pedro.baloncestoApi.model.Liga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquiposRepository extends JpaRepository<Equipo, Integer> {
    List<Equipo> findByNombre(String nombre);

    List<Equipo> findByLiga(Liga liga);

    List<Equipo> findByCiudad(String ciudad);

    Equipo findByEntrenador(String entrenador);

    Equipo findByPresidente(String presidente);
}
