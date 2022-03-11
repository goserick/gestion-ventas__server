package com.gestionventas.app.models.services.dtos;

import java.io.Serializable;
import java.util.Date;

public class PagoDTO implements Serializable{
	
	
	private Long id;
	private Double monto;
	private Date created_date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	

	private static final long serialVersionUID = 1L;
	
}
