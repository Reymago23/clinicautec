package com.utecws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utecws.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, String> {
	
	Paciente getPacienteByDui(String dui);

}
