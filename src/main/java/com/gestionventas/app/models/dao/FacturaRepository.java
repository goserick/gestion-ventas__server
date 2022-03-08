package com.gestionventas.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestionventas.app.models.entity.FacturaDTO;
import com.gestionventas.app.models.entity.Persona;

public interface FacturaRepository extends JpaRepository<FacturaDTO, Long>{
	
	public List<FacturaDTO> findByPersona(Persona persona);
	
}