package com.pedro.baloncestoApi.service;

import com.pedro.baloncestoApi.model.Equipo;
import com.pedro.baloncestoApi.model.Jugador;
import com.pedro.baloncestoApi.repository.EquiposRepository;
import com.pedro.baloncestoApi.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorServiceImpl implements IJugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private EquiposRepository equipoRepository;

    @Override
    public List<Jugador> buscarTodas() {
        return jugadorRepository.findAll();
    }

    @Override
    public Jugador buscarPorId(int id) {
        Optional<Jugador> opt = jugadorRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public void crear(Jugador jugador) {
        jugadorRepository.save(jugador);
    }

    @Override
    public Jugador actualizar(int id, Jugador jugador) {
        Optional<Jugador> opt = jugadorRepository.findById(id);
        if (opt.isPresent()) {
            Jugador jugadorActualizado = opt.get();
            jugadorActualizado.setNombre(jugador.getNombre());
            jugadorActualizado.setTitulos(jugador.getTitulos());
            jugadorActualizado.setApellido(jugador.getApellido());
            jugadorActualizado.setDorsal(jugador.getDorsal());
            jugadorActualizado.setPosicion(jugador.getPosicion());
            jugadorActualizado.setEdad(jugador.getEdad());
            jugadorActualizado.setAntiguedadLiga(jugador.getAntiguedadLiga());
            jugadorActualizado.setEquipo(jugador.getEquipo());
            jugadorRepository.save(jugadorActualizado);
            return jugadorActualizado;
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(int id) {
        jugadorRepository.deleteById(id);
    }

    @Override
    public List<Jugador> buscarPorNombre(String nombre) {
        return jugadorRepository.findByNombre(nombre);
    }

    @Override
    public List<Jugador> buscarPorApellido(String apellido) {
        return jugadorRepository.findByApellido(apellido);
    }

    @Override
    public List<Jugador> buscarPorEquipo(int id) {
        Optional<Equipo> opt = equipoRepository.findById(id);
        if (opt.isPresent()) {
            Equipo equipo = opt.get();
            return jugadorRepository.findByEquipo(equipo);
        } else {
            return null;
        }
    }

    @Override
    public List<Jugador> buscarPorAntiguedadMayor(int antiguedad) {
        return jugadorRepository.findByAntiguedadLigaGreaterThan(antiguedad);
    }

    @Override
    public List<Jugador> buscarPorAntiguedadMenor(int antiguedad) {
        return jugadorRepository.findByAntiguedadLigaLessThan(antiguedad);
    }

    @Override
    public List<Jugador> buscarPorPosicion(String posicion) {
        return jugadorRepository.findByPosicion(posicion);
    }

    @Override
    public List<Jugador> buscarPorEdadMayor(int edad) {
        return jugadorRepository.findByEdadGreaterThan(edad);
    }

    @Override
    public List<Jugador> buscarPorEdadMenor(int edad) {
        return jugadorRepository.findByEdadLessThan(edad);
    }

    @Override
    public List<Jugador> buscarPorDorsal(int dorsal) {
        return jugadorRepository.findByDorsal(dorsal);
    }

    @Override
    public List<Jugador> buscarEntreEdades(int edad1, int edad2) {
        return jugadorRepository.findByEdadBetween(edad1, edad2);
    }

}
