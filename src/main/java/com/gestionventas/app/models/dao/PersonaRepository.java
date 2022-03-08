package com.gestionventas.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionventas.app.models.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
	
}
