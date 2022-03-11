package com.gestionventas.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="facturas")
public class Factura implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String observaciones;
	
	@Column(name="created_date")
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	private Persona persona;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="factura_id")
	private List<Producto> items;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="factura_id")
	private List<Pago> pagos;
	
	
	public Factura() {
		this.items = new ArrayList<Producto>();
		this.pagos = new ArrayList<Pago>();
	}

	@PrePersist
	public void prePersist() {
		createdDate = new Date();
	}
	
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

	public Date getCreated_date() {
		return createdDate;
	}

	public void setCreated_date(Date created_date) {
		this.createdDate = created_date;
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
	
	public void addItemFactura(Producto item){
		this.items.add(item);
	}
	
	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public void addPagos(Pago pago){
		this.pagos.add(pago);
	}
	
	public Double getTotal() {
		Double total= 0.0;
		int size = items.size();
		for (int i=0; i<size; i++) {
			total= total+items.get(i).calcularImporte();
		}
		return total;
		
	}
	public Double getTotalPagos() {
		Double totalAbonos= 0.0;
		int size = pagos.size();
		for (int i=0; i<size; i++) {
			totalAbonos= totalAbonos+pagos.get(i).getMonto();
		}
		return totalAbonos;
		
	}
	
	public Double getRestante() {
		Double restante= getTotal()-getTotalPagos();
		return restante;
		
	}
	
	private static final long serialVersionUID = 1L;

}
