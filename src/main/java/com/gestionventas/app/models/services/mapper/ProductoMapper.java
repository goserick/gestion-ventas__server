package com.gestionventas.app.models.services.mapper;

import org.mapstruct.Mapper;

import com.gestionventas.app.models.entity.Producto;
import com.gestionventas.app.models.services.dtos.ProductoDTO;

@Mapper(componentModel = "spring", uses={})
public interface ProductoMapper {
	
	Producto toEntity(ProductoDTO productoDTO);
	
	ProductoDTO toDto(Producto producto);
}
