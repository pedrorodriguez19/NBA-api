package com.pedro.baloncestoApi.service;

import com.pedro.baloncestoApi.model.Equipo;
import com.pedro.baloncestoApi.model.Liga;
import com.pedro.baloncestoApi.repository.EquiposRepository;
import com.pedro.baloncestoApi.repository.LigasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoServiceImpl implements IEquipoService {

    @Autowired
    private EquiposRepository equipoRepository;

    @Autowired
    private LigasRepository ligaRepository;

    @Override
    public List<Equipo> buscarTodos() {
        return equipoRepository.findAll();
    }

    @Override
    public Equipo buscarPorId(int id) {
        Optional<Equipo> opt = equipoRepository.findById(id);
        return opt.orElse(null);
    }

    public void crearEquipo(Equipo equipo) {
        equipoRepository.save(equipo);
    }

    public void eliminarEquipo(int id) {
        equipoRepository.deleteById(id);
    }

    @Override
    public Equipo actualizarEquipo(int id, Equipo equipo) {
        Optional<Equipo> opt = equipoRepository.findById(id);
        if (opt.isPresent()) {
            Equipo equipoActualizado = opt.get();
            equipoActualizado.setNombre(equipo.getNombre());
            equipoActualizado.setCiudad(equipo.getCiudad());
            equipoActualizado.setEstadio(equipo.getEstadio());
            equipoActualizado.setPresidente(equipo.getPresidente());
            equipoActualizado.setTitulos(equipo.getTitulos());
            equipoActualizado.setFundacion(equipo.getFundacion());
            equipoActualizado.setLiga(equipo.getLiga());
            equipoRepository.save(equipoActualizado);
            return equipoActualizado;
        } else {
            return null;
        }
    }

    @Override
    public List<Equipo> buscarPorNombre(String nombre) {
        return equipoRepository.findByNombre(nombre);
    }

    @Override
    public List<Equipo> buscarPorLiga(int id) {
        Optional<Liga> opt = ligaRepository.findById(id);
        return opt.map(liga -> equipoRepository.findByLiga(liga)).orElse(null);
    }

    @Override
    public List<Equipo> buscarPorCiudad(String ciudad) {
        return equipoRepository.findByCiudad(ciudad);
    }

    @Override
    public Equipo buscarPorEntrenador(String entrenador) {
        return equipoRepository.findByEntrenador(entrenador);
    }

    @Override
    public Equipo buscarPorPresidente(String presidente) {
        return equipoRepository.findByPresidente(presidente);
    }
}
