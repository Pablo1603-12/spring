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

import com.example.alumnossalesianas.models.Alumno;
import com.example.alumnossalesianas.repository.AlumnoRepository;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AlumnoController {

	@Autowired
	AlumnoRepository alumnoRepository;

	@GetMapping("/alumno")
	public ResponseEntity<List<Alumno>> getAlumnos(@RequestParam(required = false) String DNI) {
		try {
			List<Alumno> alumnos = new ArrayList<Alumno>();

			if (DNI == null)
				alumnoRepository.findAll().forEach(alumnos::add);
			else
				alumnoRepository.findByDNI(DNI).forEach(alumnos::add);

			if (alumnos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(alumnos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@GetMapping("/alumno/{DNI}")
	public ResponseEntity<Alumno> getAlumnosPorId(@PathVariable("DNI") String DNI) {
		Optional<Alumno> alumnoData = alumnoRepository.findById(DNI);

		if (alumnoData.isPresent()) {
			return new ResponseEntity<>(alumnoData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/alumno")
	public ResponseEntity<Alumno> crearAlumno(@RequestBody Alumno alumno) {
		try {
			Alumno _alumno = alumnoRepository.save(new Alumno(alumno.getDNI(), alumno.getNombre(), alumno.getGrupo(), alumno.getNumMatricula(), alumno.getExamen(), alumno.getPractica()));
		
			return new ResponseEntity<>(_alumno, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/alumno/{DNI}")
	public ResponseEntity<Alumno> actualizarAlumno(@PathVariable("DNI") String DNI, @RequestBody Alumno alumno) {
		Optional<Alumno> alumnoData = alumnoRepository.findById((DNI) );

		if (alumnoData.isPresent()) {
			Alumno _alumno = alumnoData.get();
			_alumno.setDNI(_alumno.getDNI());
			_alumno.setNombre(_alumno.getNombre());
			_alumno.setGrupo(_alumno.getGrupo());
			_alumno.setNumMatricula(_alumno.getNumMatricula());
			_alumno.setExamen(_alumno.getExamen());
			_alumno.setPractica(_alumno.getPractica());
			return new ResponseEntity<>(alumnoRepository.save(_alumno), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/alumno/{DNI}")
	public ResponseEntity<HttpStatus> eliminarProfesor(@PathVariable("DNI") String DNI) {
		try {
			alumnoRepository.deleteById(DNI);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/alumno")
	public ResponseEntity<HttpStatus> eliminarTodosprofesor() {
		try {
			alumnoRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


}


