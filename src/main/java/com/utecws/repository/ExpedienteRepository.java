package com.utecws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utecws.entity.Expediente;

public interface ExpedienteRepository extends JpaRepository<Expediente, String>{
	
	Expediente getExpedienteByDuiPaciente(String dui);

}
