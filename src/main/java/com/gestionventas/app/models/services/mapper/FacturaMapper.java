package com.gestionventas.app.models.services.mapper;

import org.mapstruct.*;

import com.gestionventas.app.models.entity.Factura;
import com.gestionventas.app.models.services.dtos.FacturaDTO;

@Mapper(componentModel = "spring", uses={})
public interface FacturaMapper{
	
	FacturaDTO toDto(Factura factura);
	Factura toEntity(FacturaDTO facturaDTO);
}
