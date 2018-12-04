package com.utecws.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="paciente")
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "dui_paciente")
	private String dui;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="clave")
	private String clave;
	
	@Column(name="correo")
	private String correo;
	
	public Paciente(String dui, String nombre, String clave, String correo) {
		this.dui = dui;
		this.nombre = nombre;
		this.clave = clave;
		this.correo = correo;
	}

	public Paciente() {
		super();
	}

	@Override
	public String toString() {
		return "Paciente [dui=" + dui + ", nombre=" + nombre + ", clave=" + clave + ", correo=" + correo + "]";
	}

	public String getDui() {
		return dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
}
