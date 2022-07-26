package com.pedro.baloncestoApi.service;

import com.pedro.baloncestoApi.model.Equipo;

import java.util.List;

public interface IEquipoService {
    List<Equipo> buscarTodos();

    Equipo buscarPorId(int id);

    void crearEquipo(Equipo equipo);

    void eliminarEquipo(int id);

    Equipo actualizarEquipo(int id, Equipo equipo);

    List<Equipo> buscarPorNombre(String nombre);

    List<Equipo> buscarPorLiga(int id);

    List<Equipo> buscarPorCiudad(String ciudad);

    Equipo buscarPorEntrenador(String entrenador);

    Equipo buscarPorPresidente(String presidente);
}
