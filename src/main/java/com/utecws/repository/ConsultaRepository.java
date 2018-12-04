package com.utecws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utecws.entity.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, String> {
	
	Consulta getConsultaByDuiPacienteAndEstadoConsultaAndFecha(String dui, int estado, String fecha );
	List<Consulta> getConsultasByDuiPaciente(String dui); 
	List<Consulta> getConsultasByDuiMedico(String dui);
	List<Consulta> getConsultasByEstadoConsulta(int estado);
	long countDistinctByFechaAndHora(String fecha, String hora);
	
}
