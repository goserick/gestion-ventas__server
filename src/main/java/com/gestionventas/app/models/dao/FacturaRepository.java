package com.gestionventas.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestionventas.app.models.entity.Factura;
import com.gestionventas.app.models.entity.Persona;

public interface FacturaRepository extends JpaRepository<Factura, Long>{
	
	public List<Factura> findByPersona(Persona persona);
	
}