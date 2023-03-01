package com.example.alumnossalesianas.models;




import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name = "Examen")
public class Examen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idExamen;

	@Column(name = "nombreExamen", length = 20)
	private String nombreExamen;
	
	@Column(name = "numPreguntas")
	Integer numPreguntas;
	

	@Column(name = "Fecha", unique=true)
	Date fecha;

	public Examen(int idExamen, String nombreExamen, Integer numPreguntas, Date fecha) {
		super();
		this.idExamen = idExamen;
		this.nombreExamen = nombreExamen;
		this.numPreguntas = numPreguntas;
		this.fecha = fecha;
	}

	public Examen() {
		super();
	}

	public int getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	public String getNombreExamen() {
		return nombreExamen;
	}

	public void setNombreExamen(String nombreExamen) {
		this.nombreExamen = nombreExamen;
	}

	public Integer getNumPreguntas() {
		return numPreguntas;
	}

	public void setNumPreguntas(Integer numPreguntas) {
		this.numPreguntas = numPreguntas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Examen [idExamen=" + idExamen + ", nombreExamen=" + nombreExamen + ", numPreguntas=" + numPreguntas
				+ ", fecha=" + fecha + "]";
	}



	
	
	
	
	
	

     
}
