package com.pedro.baloncestoApi.service;

import com.pedro.baloncestoApi.model.Liga;

import java.util.List;

public interface ILigaService {

    List<Liga> buscarTodas();

    Liga buscarPorId(int id);

    void insertar(Liga liga);

    void eliminar(int id);

    Liga actualizar(int id, Liga liga);

    List<Liga> buscarPorNombre(String nombre);

    List<Liga> buscarPorUbicacion(String ubicacion);
}
