package com.utecws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utecws.entity.Enfermera;

public interface EnfermeraRepository extends JpaRepository<Enfermera, String> {
	Enfermera getEnfermeraByDuiAndClave(String dui, String clave);
}
