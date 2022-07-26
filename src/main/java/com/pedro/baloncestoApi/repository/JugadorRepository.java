package com.pedro.baloncestoApi.repository;

import com.pedro.baloncestoApi.model.Equipo;
import com.pedro.baloncestoApi.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
    List<Jugador> findByNombre(String nombre);

    List<Jugador> findByEquipo(Equipo equipo);

    List<Jugador> findByApellido(String apellido);

    List<Jugador> findByAntiguedadLigaGreaterThan(int antiguedadLiga);

    List<Jugador> findByAntiguedadLigaLessThan(int antiguedadLiga);

    List<Jugador> findByPosicion(String posicion);

    List<Jugador> findByDorsal(int dorsal);

    List<Jugador> findByEdadGreaterThan(int edad);

    List<Jugador> findByEdadLessThan(int edad);

    List<Jugador> findByEdadBetween(int edad, int edad2);

}
