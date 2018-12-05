package com.utecws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utecws.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, String> {

	
	Medico getMedicoByDuiAndClave(String dui, String clave);
}

