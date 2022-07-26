package com.pedro.baloncestoApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String ciudad;
    private String estadio;
    private Integer titulos;
    private Date fundacion;
    private String presidente;
    private String entrenador;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "equiposliga", joinColumns = @JoinColumn(name = "idEquipo"), inverseJoinColumns = @JoinColumn(name = "idLiga"))
    @JsonBackReference
    private List<Liga> liga;

    @OneToMany(mappedBy = "equipo")
    private List<Jugador> jugadores;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Integer getTitulos() {
        return titulos;
    }

    public void setTitulos(Integer titulos) {
        this.titulos = titulos;
    }

    public Date getFundacion() {
        return fundacion;
    }


    public void setFundacion(Date fundacion) {
        this.fundacion = fundacion;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public List<Liga> getLiga() {
        return liga;
    }

    public void setLiga(List<Liga> liga) {
        this.liga = liga;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

}
