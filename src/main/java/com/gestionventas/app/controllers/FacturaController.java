package com.gestionventas.app.controllers;

import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestionventas.app.models.dao.FacturaRepository;
import com.gestionventas.app.models.entity.Factura;
import com.gestionventas.app.models.entity.Persona;
import com.gestionventas.app.models.services.IPersonaService;
import com.gestionventas.app.models.services.dtos.FacturaDTO;

import ch.qos.logback.classic.Logger;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FacturaController {
	
	
	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private FacturaRepository facturaRepository;
	
	@GetMapping("/facturas/{PerosnaId}")
	public ResponseEntity<List<Factura>> ConsultaFacturas(@PathVariable Long PerosnaId) {
		Persona persona = personaService.findById(PerosnaId);
		List<Factura> facturas =facturaRepository.findByPersona(persona);
		
		
		return new ResponseEntity<>(facturas,HttpStatus.OK);
	}
	
	@GetMapping("/factura/{id}")
	public ResponseEntity<FacturaDTO> ConsultaFactura(@PathVariable Long id) {
		FacturaDTO factura =personaService.findFacturaByid(id);
		return new ResponseEntity<>(factura,HttpStatus.OK);
	}
	
	@PostMapping("/factura")
	public ResponseEntity<FacturaDTO> ConsultaFactura(@RequestBody FacturaDTO facturaDTO) {
		System.out.println(facturaDTO.getPersona().getId());
		
		FacturaDTO facturanueva =personaService.saveFactura(facturaDTO);
		return new ResponseEntity<>(facturanueva,HttpStatus.OK);
	}
	
	@PostMapping("/factura/agregar-productos/{id}")
	public ResponseEntity<FacturaDTO> ConsultaFactura(@RequestParam Long id, @RequestBody FacturaDTO facturaDTO) {
		
		FacturaDTO factura =personaService.findFacturaByid(id);
		
		
		return new ResponseEntity<>(factura,HttpStatus.OK);
	}
}
