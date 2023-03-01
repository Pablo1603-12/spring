package com.example.alumnossalesianas.models;

import java.util.*;

import javax.persistence.*;




@Entity
@Table(name = "Profesor")
public class Profesor {

	//VARIABLES
	
	@Id
	@Column(length = 9)
    private String DNI;
	
	@Column(name = "nombre", length = 20)
    private String nombre;
	

	@ManyToMany
	private List<Practica> practicas;
	
    //private Control control;
	
	//COSTRUCTOR
	
	public Profesor() {
	}

	public Profesor(String DNI, String nombre, List<Practica> practicas) {
		super();
		this.DNI = DNI;
		this.nombre = nombre;
		this.practicas = practicas;
	}

	//GET Y SET
	
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Practica> getPracticas() {
		return practicas;
	}

	public void setPracticas(List<Practica> practicas) {
		this.practicas = practicas;
	}

	@Override
	public String toString() {
		return "Profesor [DNI=" + DNI + ", nombre=" + nombre + ", practicas=" + practicas + "]";
	}
		
}
