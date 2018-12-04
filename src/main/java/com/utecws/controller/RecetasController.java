package com.utecws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utecws.entity.Consulta;
import com.utecws.entity.Recetas;
import com.utecws.repository.RecetasRepository;

@RestController
@RequestMapping("/recetas")
public class RecetasController {
	
	
	@Autowired
	private RecetasRepository recetasRepository;
	
	@PostMapping(produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Recetas> addConsulta(@RequestBody Recetas receta) {
		
       return new ResponseEntity<Recetas>(recetasRepository.save(receta), HttpStatus.CREATED);
	}

}
