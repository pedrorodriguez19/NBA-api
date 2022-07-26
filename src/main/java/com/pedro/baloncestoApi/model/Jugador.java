package com.pedro.baloncestoApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "jugadores")
public class Jugador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private String posicion;
	private Integer dorsal;
	@ManyToOne
	@JoinColumn(name = "IdEquipo")
	@JsonBackReference
	private Equipo equipo;
	private Integer edad;
	private Integer antiguedadLiga;
	private Integer titulos;

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public Integer getDorsal() {
		return dorsal;
	}

	public void setDorsal(Integer dorsal) {
		this.dorsal = dorsal;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getAntiguedadLiga() {
		return antiguedadLiga;
	}

	public void setAntiguedadLiga(Integer antiguedadLiga) {
		this.antiguedadLiga = antiguedadLiga;
	}

	public Integer getTitulos() {
		return titulos;
	}

	public void setTitulos(Integer titulos) {
		this.titulos = titulos;
	}

}
