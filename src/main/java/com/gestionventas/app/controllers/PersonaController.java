package com.gestionventas.app.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.gestionventas.app.models.entity.Persona;
import com.gestionventas.app.models.services.IPersonaService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PersonaController {
	
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/personas")
	public List<Persona> index() {
		return personaService.findAll();
	}
	
	@GetMapping("/personas/{id}")
	public ResponseEntity<Persona> ConsultaPersona(@PathVariable Long id) {
		Persona persona=personaService.findById(id);
		
		return new ResponseEntity<>(persona,HttpStatus.OK);
	}
	
	@PutMapping("/personas/{id}")
	public ResponseEntity<Persona> update(@PathVariable Long id, @RequestBody Persona persona) {
		Persona personanueva=personaService.save(persona);
		return new ResponseEntity<>(personanueva,HttpStatus.OK);
	}
	
	@PostMapping("/personas")
	public ResponseEntity<Persona> create(@RequestBody Persona persona) {
		Persona personanueva=personaService.save(persona);
				
	    return new ResponseEntity<>(personanueva,HttpStatus.OK);
	}
	
	@DeleteMapping("/personas/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id, @RequestBody Persona persona) {
		personaService.save(null) ;
		return new ResponseEntity<>("eliminado correcatamente",HttpStatus.OK);
	}
}
