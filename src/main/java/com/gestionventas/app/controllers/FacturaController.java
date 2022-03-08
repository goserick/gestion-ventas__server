package com.gestionventas.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionventas.app.models.dao.FacturaRepository;
import com.gestionventas.app.models.entity.FacturaDTO;
import com.gestionventas.app.models.entity.Persona;
import com.gestionventas.app.models.services.IPersonaService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FacturaController {
	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private FacturaRepository facturaRepository;
	
	@GetMapping("/facturas/{PerosnaId}")
	public ResponseEntity<List<FacturaDTO>> ConsultaFacturas(@PathVariable Long PerosnaId) {
		Persona persona = personaService.findById(PerosnaId);
		List<FacturaDTO> facturas =facturaRepository.findByPersona(persona);
		
		
		return new ResponseEntity<>(facturas,HttpStatus.OK);
	}
	
	@GetMapping("/factura/{id}")
	public ResponseEntity<FacturaDTO> ConsultaFactura(@PathVariable Long id) {
		FacturaDTO factura =personaService.findFacturaByid(id);
		return new ResponseEntity<>(factura,HttpStatus.OK);
	}
}
