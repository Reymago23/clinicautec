package com.utecws.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name ="consulta")
public class Consulta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name= "id_consulta")
	int id;
	
	@Column(name= "razon_consulta")
	private String razonConsulta;
	
	@Column(name= "sintomas")
	private String sintomas;
	
	@Column(name= "fecha")
	private String fecha;
	
	@Column(name= "hora")
	private String hora;
	
	@Column(name= "estado_consulta")
	private int estadoConsulta;
	
	@Column(name= "dui_medico")
	private String duiMedico;
	
	@Column(name= "dui_paciente")
	private String duiPaciente;
	
	public Consulta() {
		super();
	}

	@Override
	public String toString() {
		return "Consulta [id=" + id + ", razonConsulta=" + razonConsulta + ", sintomas=" + sintomas + ", fecha=" + fecha
				+ ", hora=" + hora + ", estadoConsulta=" + estadoConsulta + ", duiMedico=" + duiMedico
				+ ", duiPaciente=" + duiPaciente + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazonConsulta() {
		return razonConsulta;
	}

	public void setRazonConsulta(String razonConsulta) {
		this.razonConsulta = razonConsulta;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getEstadoConsulta() {
		return estadoConsulta;
	}

	public void setEstadoConsulta(int estadoConsulta) {
		this.estadoConsulta = estadoConsulta;
	}

	public String getDuiMedico() {
		return duiMedico;
	}

	public void setDuiMedico(String duiMedico) {
		this.duiMedico = duiMedico;
	}

	public String getDuiPaciente() {
		return duiPaciente;
	}

	public void setDuiPaciente(String duiPaciente) {
		this.duiPaciente = duiPaciente;
	}
	
	
	

}
