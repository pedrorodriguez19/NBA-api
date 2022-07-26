package com.pedro.baloncestoApi.service;

import com.pedro.baloncestoApi.model.Liga;
import com.pedro.baloncestoApi.repository.LigasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigaServiceImpl implements ILigaService {

    @Autowired
    LigasRepository ligasRepository;

    @Override
    public List<Liga> buscarTodas() {
        return ligasRepository.findAll();
    }

    @Override
    public Liga buscarPorId(int id) {
        Optional<Liga> optional = ligasRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void insertar(Liga liga) {
        ligasRepository.save(liga);
    }

    @Override
    public void eliminar(int id) {
        ligasRepository.deleteById(id);
    }

    @Override
    public Liga actualizar(int id, Liga liga) {
        Optional<Liga> optional = ligasRepository.findById(id);
        if (optional.isPresent()) {
            Liga ligaActualizar = optional.get();
            ligaActualizar.setNombre(liga.getNombre());
            ligaActualizar.setUbicacion(liga.getUbicacion());
            ligaActualizar.setFechaCreacion(liga.getFechaCreacion());
            ligasRepository.save(ligaActualizar);
            return ligaActualizar;
        } else {
            return null;
        }
    }

    @Override
    public List<Liga> buscarPorNombre(String nombre) {
        return ligasRepository.findByNombre(nombre);
    }

    @Override
    public List<Liga> buscarPorUbicacion(String ubicacion) {
        return ligasRepository.findByUbicacion(ubicacion);
    }

}
