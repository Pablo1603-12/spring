package com.example.alumnossalesianas.models;



import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "Alumno")
public class Alumno {

	// VARIABLES
	@Id
	@Column(length = 9)
	private String DNI;

	@Column(name = "nombre", length = 20)
	private String nombre;

	@Column(name = "grupo", length = 5)
	private String grupo;

	@Column(name = "numMatricula")
	private int numMatricula;
	
	@ManyToMany
	@OrderColumn(name = "nota")
	private List<Examen> examen;
	

	@ManyToMany
	@OrderColumn(name = "nota")
	private List<Practica> practica;
	
	
	public Alumno() {
		super();
	}


	public Alumno(String dNI, String nombre, String grupo, int numMatricula, List<Examen> examen,
			List<Practica> practica) {
		super();
		DNI = dNI;
		this.nombre = nombre;
		this.grupo = grupo;
		this.numMatricula = numMatricula;
		this.examen = examen;
		this.practica = practica;
	}

	


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


	public String getGrupo() {
		return grupo;
	}


	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}


	public int getNumMatricula() {
		return numMatricula;
	}


	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}


	public List<Examen> getExamen() {
		return examen;
	}


	public void setExamen(List<Examen> examen) {
		this.examen = examen;
	}


	public List<Practica> getPractica() {
		return practica;
	}


	public void setPractica(List<Practica> practica) {
		this.practica = practica;
	}


	@Override
	public String toString() {
		return "Alumno [DNI=" + DNI + ", nombre=" + nombre + ", grupo=" + grupo + ", numMatricula=" + numMatricula
				+ ", examen=" + examen + ", practica=" + practica + "]";
	}
	
	
	

	


	


	




	
	
	
	
	
	
	

	
}


