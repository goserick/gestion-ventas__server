package com.gestionventas.app.models.services.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.gestionventas.app.models.entity.Pago;
import com.gestionventas.app.models.entity.Persona;
import com.gestionventas.app.models.entity.Producto;

public class FacturaDTO implements Serializable {

	private Long id;
	private String nombre;
	private String observaciones;
	private Date createdDate;
	private Persona persona;
	private List<Producto> items;
	private List<Pago> pagos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Producto> getItems() {
		return items;
	}

	public void setItems(List<Producto> items) {
		this.items = items;
	}

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public Double getTotal() {
		Double total = 0.0;
		int size = items.size();
		for (int i = 0; i < size; i++) {
			total = total + items.get(i).calcularImporte();
		}
		return total;

	}

	public Double getTotalPagos() {
		Double totalAbonos = 0.0;
		int size = pagos.size();
		for (int i = 0; i < size; i++) {
			totalAbonos = totalAbonos + pagos.get(i).getMonto();
		}
		return totalAbonos;

	}

	public Double getRestante() {
		Double restante = getTotal() - getTotalPagos();
		return restante;

	}

	private static final long serialVersionUID = 1L;

}
