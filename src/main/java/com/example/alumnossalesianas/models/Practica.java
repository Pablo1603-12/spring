package com.example.alumnossalesianas.models;


import javax.persistence.*;


@Entity
@Table(name = "Practica")
public class Practica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdPractica")
	int IdPractica;

	
    
	@Column(name = "nombrePractica", length = 20)
    String nombrePractica;
	
	
	@Column(name = "difucultad")
	@Enumerated(value = EnumType.ORDINAL)
    Dificultad dificultad;
	
	
	

	public Practica(int idPractica, String nombrePractica, Dificultad dificultad) {
		super();
		IdPractica = idPractica;
		this.nombrePractica = nombrePractica;
		this.dificultad = dificultad;
	}

	public Practica() {
		super();
	}

	public int getIdPractica() {
		return IdPractica;
	}

	public void setIdPractica(int idPractica) {
		IdPractica = idPractica;
	}

	public String getNombrePractica() {
		return nombrePractica;
	}

	public void setNombrePractica(String nombrePractica) {
		this.nombrePractica = nombrePractica;
	}

	public Dificultad getDificultad() {
		return dificultad;
	}

	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}

	@Override
	public String toString() {
		return "Practica [IdPractica=" + IdPractica + ", nombrePractica=" + nombrePractica
				+ ", dificultad=" + dificultad + "]";
	}
    
	
	
	

	

     
}
