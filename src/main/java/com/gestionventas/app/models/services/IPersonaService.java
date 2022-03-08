package com.gestionventas.app.models.services;

import java.util.List;

import com.gestionventas.app.models.entity.FacturaDTO;
import com.gestionventas.app.models.entity.Persona;

public interface IPersonaService {
	
	public List<Persona> findAll();
	
	public Persona findById(Long id);
	
	public Persona save(Persona persona);
	
	public void delete(Long id);
	
	public FacturaDTO findFacturaByid(Long id);
	
}
