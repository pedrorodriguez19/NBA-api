package com.pedro.baloncestoApi.controller;

import com.pedro.baloncestoApi.model.Liga;
import com.pedro.baloncestoApi.service.LigaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webapi/liga")
public class LigaController {

    @Autowired
    private LigaServiceImpl ligaService;

    @GetMapping("/buscar")
    public List<Liga> buscarTodas() {
        return ligaService.buscarTodas();
    }

    @GetMapping("/buscar/{id}")
    public Liga buscarPorId(@PathVariable int id) {
        return ligaService.buscarPorId(id);
    }

    @PostMapping("/crear")
    public void crear(@RequestBody Liga liga) {
        ligaService.insertar(liga);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id) {
        ligaService.eliminar(id);
    }

    @PutMapping("/actualizar/{id}")
    public Liga actualizar(@PathVariable int id, @RequestBody Liga liga) {
        return ligaService.actualizar(id, liga);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Liga> buscarPorNombre(@PathVariable String nombre) {
        return ligaService.buscarPorNombre(nombre);
    }

    @GetMapping("/ubicacion/{ubicacion}")
    public List<Liga> buscarPorUbicacion(@PathVariable String ubicacion) {
        return ligaService.buscarPorUbicacion(ubicacion);
    }
}
