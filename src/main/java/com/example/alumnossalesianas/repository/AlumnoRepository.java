package com.example.alumnossalesianas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.alumnossalesianas.models.Alumno;


@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, String>{
	List<Alumno> findByDNI(String DNI);;
}
