package com.utecws.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="recetas")
public class Recetas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name= "id_receta")
	private long id;
	
	@Column(name="fecha_prescripcion")
	private String fechaPrescripcion;
	
	@Column(name="password")
	private String password;
	
	@Column(name="farmaco")
	private String farmaco;
	
	@Column(name="unidades")
	private int unidades;
	
	@Column(name="pauta")
	private String pauta;
	
	@Column(name="indicaciones_farmaco")
	private String indicacionesFarmaco;
	
	@Column(name="dui_paciente")
	private String duiPaciente;
	
	@Column(name="dui_enfermera")
	private String duiEnfermera;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFechaPrescripcion() {
		return fechaPrescripcion;
	}

	public void setFechaPrescripcion(String fechaPrescripcion) {
		this.fechaPrescripcion = fechaPrescripcion;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFarmaco() {
		return farmaco;
	}

	public void setFarmaco(String farmaco) {
		this.farmaco = farmaco;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String getPauta() {
		return pauta;
	}

	public void setPauta(String pauta) {
		this.pauta = pauta;
	}

	public String getIndicacionesFarmaco() {
		return indicacionesFarmaco;
	}

	public void setIndicacionesFarmaco(String indicacionesFarmaco) {
		this.indicacionesFarmaco = indicacionesFarmaco;
	}

	public String getDuiPaciente() {
		return duiPaciente;
	}

	public void setDuiPaciente(String duiPaciente) {
		this.duiPaciente = duiPaciente;
	}

	public String getDuiEnfermera() {
		return duiEnfermera;
	}

	public void setDuiEnfermera(String duiEnfermera) {
		this.duiEnfermera = duiEnfermera;
	}
	
	
	
}
