package com.pedro.baloncestoApi.controller;

import com.pedro.baloncestoApi.model.Jugador;
import com.pedro.baloncestoApi.service.JugadorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webapi/jugador")
public class JugadorController {

    @Autowired
    private JugadorServiceImpl jugadorService;

    @GetMapping("/buscar")
    public List<Jugador> getAllJugadores() {
        return jugadorService.buscarTodas();
    }

    @GetMapping("/buscar/{id}")
    public Jugador buscarPorId(@PathVariable int id) {
        return jugadorService.buscarPorId(id);
    }

    @PostMapping("/crear")
    public void crearJugador(@RequestBody Jugador jugador) {
        jugadorService.crear(jugador);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarJugador(@PathVariable int id) {
        jugadorService.eliminar(id);
    }

    @PutMapping("/actualizar/{id}")
    public Jugador actualizarJugador(@PathVariable int id, @RequestBody Jugador jugador) {
        return jugadorService.actualizar(id, jugador);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Jugador> buscarPorNombre(@PathVariable String nombre) {
        return jugadorService.buscarPorNombre(nombre);
    }

    @GetMapping("/equipo/{id}")
    public List<Jugador> buscarPorEquipo(@PathVariable int id) {
        return jugadorService.buscarPorEquipo(id);
    }

    @GetMapping("/apellido/{apellido}")
    public List<Jugador> buscarPorApellido(@PathVariable String apellido) {
        return jugadorService.buscarPorApellido(apellido);
    }

    @GetMapping("/antiguedadMayor/{antiguedad}")
    public List<Jugador> buscarPorAntiguedadMayor(@PathVariable int antiguedad) {
        return jugadorService.buscarPorAntiguedadMayor(antiguedad);
    }

    @GetMapping("/antiguedadMenor/{antiguedad}")
    public List<Jugador> buscarPorAntiguedadMenor(@PathVariable int antiguedad) {
        return jugadorService.buscarPorAntiguedadMenor(antiguedad);
    }

    @GetMapping("/posicion/{posicion}")
    public List<Jugador> buscarPorPosicion(@PathVariable String posicion) {
        return jugadorService.buscarPorPosicion(posicion);
    }

    @GetMapping("/edadMayor/{edad}")
    public List<Jugador> buscarPorEdadMayor(@PathVariable int edad) {
        return jugadorService.buscarPorEdadMayor(edad);
    }

    @GetMapping("/edadMenor/{edad}")
    public List<Jugador> buscarPorEdadMenor(@PathVariable int edad) {
        return jugadorService.buscarPorEdadMenor(edad);
    }

    @GetMapping("/dorsal/{dorsal}")
    public List<Jugador> buscarPorDorsal(@PathVariable int dorsal) {
        return jugadorService.buscarPorDorsal(dorsal);
    }

    @GetMapping("/edad/{edad}/{edad2}")
    public List<Jugador> buscarPorEdad(@PathVariable int edad, @PathVariable int edad2) {
        return jugadorService.buscarEntreEdades(edad, edad2);
    }
}
