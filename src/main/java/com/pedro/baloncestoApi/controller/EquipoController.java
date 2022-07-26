package com.pedro.baloncestoApi.controller;

import com.pedro.baloncestoApi.model.Equipo;
import com.pedro.baloncestoApi.service.EquipoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webapi/equipo")
public class EquipoController {

    @Autowired
    private EquipoServiceImpl equipoService;

    @GetMapping("/buscar")
    public List<Equipo> buscarTodos() {
        return equipoService.buscarTodos();
    }

    @GetMapping("/buscar/{id}")
    public Equipo buscarPorId(@PathVariable int id) {
        return equipoService.buscarPorId(id);
    }

    @PostMapping("/crear")
    public void crearEquipo(@RequestBody Equipo equipo) {
        equipoService.crearEquipo(equipo);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarEquipo(@PathVariable int id) {
        equipoService.eliminarEquipo(id);
    }

    @PutMapping("/actualizar/{id}")
    public Equipo actualizarEquipo(@PathVariable int id, @RequestBody Equipo equipo) {
        return equipoService.actualizarEquipo(id, equipo);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Equipo> buscarPorNombre(@PathVariable String nombre) {
        return equipoService.buscarPorNombre(nombre);
    }

    @GetMapping("/liga/{id}")
    public List<Equipo> buscarPorLiga(@PathVariable int id) {
        return equipoService.buscarPorLiga(id);
    }

    @GetMapping("/ciudad/{ciudad}")
    public List<Equipo> buscarPorCiudad(@PathVariable String ciudad) {
        return equipoService.buscarPorCiudad(ciudad);
    }

    @GetMapping("/entrenador/{nombre}")
    public Equipo buscarPorEntrenador(@PathVariable String nombre) {
        return equipoService.buscarPorEntrenador(nombre);
    }

    @GetMapping("/presidente/{nombre}")
    public Equipo buscarPorPresidente(@PathVariable String nombre) {
        return equipoService.buscarPorPresidente(nombre);
    }

}
