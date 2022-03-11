package com.gestionventas.app.models.services.mapper;

import org.mapstruct.Mapper;

import com.gestionventas.app.models.entity.Persona;
import com.gestionventas.app.models.services.dtos.PersonaDTO;

@Mapper(componentModel = "spring", uses={})
public interface PersonaMapper {
	
	Persona toEntity(PersonaDTO personaDTO);
	PersonaDTO toDto(Persona persona);

}
