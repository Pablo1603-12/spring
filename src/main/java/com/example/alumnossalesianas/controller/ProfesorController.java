package com.example.alumnossalesianas.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.alumnossalesianas.models.Profesor;
import com.example.alumnossalesianas.repository.ProfesorRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProfesorController {

	@Autowired
	ProfesorRepository profesorRepository;

	@GetMapping("/profesor")
	public ResponseEntity<List<Profesor>> getTodosProfesor(@RequestParam(required = false) String DNI) {
		try {
			List<Profesor> profesores = new ArrayList<Profesor>();

			if (DNI == null)
				profesorRepository.findAll().forEach(profesores::add);
			else
				profesorRepository.findByDNI(DNI).forEach(profesores::add);

			if (profesores.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(profesores, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/profesor/{DNI}")
	public ResponseEntity<Profesor> getAlumnosPorId(@PathVariable("DNI") String DNI) {
		Optional<Profesor> profesorData = profesorRepository.findById(DNI);

		if (profesorData.isPresent()) {
			return new ResponseEntity<>(profesorData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/profesor")
	public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor profesor) {
		try {
			Profesor _profesor = profesorRepository.save(new Profesor(profesor.getDNI(), profesor.getNombre(), profesor.getPracticas()));
		
			return new ResponseEntity<>(_profesor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/profesor/{DNI}")
	public ResponseEntity<Profesor> actualizarAlumno(@PathVariable("DNI") String DNI, @RequestBody Profesor profesor) {
		Optional<Profesor> profesorData = profesorRepository.findById((String) DNI);

		if (profesorData.isPresent()) {
			Profesor _profesor = profesorData.get();
			_profesor.setNombre(profesor.getNombre());
			_profesor.setPracticas(profesor.getPracticas());
			return new ResponseEntity<>(profesorRepository.save(_profesor), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/profesor/{DNI}")
	public ResponseEntity<HttpStatus> eliminarProfesor(@PathVariable("DNI") String DNI) {
		try {
			profesorRepository.deleteById(DNI);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/profesor")
	public ResponseEntity<HttpStatus> eliminarTodosprofesor() {
		try {
			profesorRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


}


