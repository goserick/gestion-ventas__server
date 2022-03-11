package com.gestionventas.app.models.services.mapper;

import org.mapstruct.Mapper;

import com.gestionventas.app.models.entity.Pago;
import com.gestionventas.app.models.services.dtos.PagoDTO;

@Mapper(componentModel = "spring", uses={})
public interface PagoMapper {
	
	Pago toEntity(PagoDTO pagoDTO);
	PagoDTO toDto(Pago pago);
}
