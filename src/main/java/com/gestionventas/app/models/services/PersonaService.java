package com.gestionventas.app.models.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionventas.app.models.dao.FacturaRepository;
import com.gestionventas.app.models.dao.PersonaRepository;
import com.gestionventas.app.models.entity.FacturaDTO;
import com.gestionventas.app.models.entity.Persona;

@Service
public class PersonaService implements IPersonaService{
	
	@Autowired
	private PersonaRepository personaRepository;
	
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
		return facturaRepository.findById(id).orElse(null);	
	}

}
