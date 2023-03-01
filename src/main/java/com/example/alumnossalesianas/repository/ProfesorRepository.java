package com.example.alumnossalesianas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.alumnossalesianas.models.Profesor;



@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, String>{
	List<Profesor> findByDNI(String DNI);;

}
