package com.gestionventas.app.models.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionventas.app.models.dao.FacturaRepository;
import com.gestionventas.app.models.dao.PersonaRepository;
import com.gestionventas.app.models.entity.Factura;
import com.gestionventas.app.models.entity.Persona;
import com.gestionventas.app.models.services.dtos.FacturaDTO;
import com.gestionventas.app.models.services.mapper.FacturaMapper;

@Service
public class PersonaService implements IPersonaService{
	
	@Autowired
	private PersonaRepository personaRepository;
	
	
	@Autowired
	private FacturaMapper facturaMaper;

	@Autowired
	private FacturaRepository facturaRepository;
	
	@Override
	@Transactional
	public List<Persona> findAll() {
		return personaRepository.findAll();
	}

	@Override
	public Persona findById(Long id) {
		return personaRepository.findById(id).orElse(null);
	}

	@Override
	public Persona save(Persona persona) {
		return personaRepository.save(persona) ;
	}

	@Override
	public void delete(Long id) {
		personaRepository.deleteById(id);
	}
	
	@Override
	public FacturaDTO findFacturaByid(Long id) {
		
		Factura factura = facturaRepository.findById(id).orElse(null);
		if (factura.getId()==null) {
			return null;
		}
		return facturaMaper.toDto(factura);	
	}

	@Override
	public FacturaDTO saveFactura(FacturaDTO facturaDTO) {
		Factura factura= facturaMaper.toEntity(facturaDTO);
		factura = facturaRepository.save(factura);
		return facturaMaper.toDto(factura);
				
//		return null;
	}

}
