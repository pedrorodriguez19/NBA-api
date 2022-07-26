package com.pedro.baloncestoApi.service;

import com.pedro.baloncestoApi.model.Jugador;

import java.util.List;

public interface IJugadorService {
    List<Jugador> buscarTodas();

    Jugador buscarPorId(int id);

    void crear(Jugador jugador);

    Jugador actualizar(int id, Jugador jugador);

    void eliminar(int id);

    List<Jugador> buscarPorNombre(String nombre);

    List<Jugador> buscarPorApellido(String apellido);

    List<Jugador> buscarPorEquipo(int id);

    List<Jugador> buscarPorAntiguedadMayor(int antiguedad);

    List<Jugador> buscarPorAntiguedadMenor(int antiguedad);


    List<Jugador> buscarPorPosicion(String posicion);

    List<Jugador> buscarPorEdadMayor(int edad);

    List<Jugador> buscarPorEdadMenor(int edad);

    List<Jugador> buscarPorDorsal(int dorsal);

    List<Jugador> buscarEntreEdades(int edad1, int edad2);
}
