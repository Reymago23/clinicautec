package com.utecws.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utecws.entity.Paciente;
import com.utecws.repository.PacienteRepository;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
	
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@GetMapping(value = "/{dui}", produces= { MediaType.APPLICATION_JSON_VALUE } ) 
	public ResponseEntity<Paciente> getPaciente(@PathVariable String dui) {
		
	   Paciente paciente = pacienteRepository.getPacienteByDui(dui);
       return new ResponseEntity<Paciente>(paciente , HttpStatus.OK);
     }
	
	
	@GetMapping(produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Paciente>> getPacientes() {
		
        
		List<Paciente> Pacientes = pacienteRepository.findAll();
                
        if (!Pacientes.isEmpty()) {
                	
              return new ResponseEntity<List<Paciente>>(Pacientes, HttpStatus.OK);
          }
        
       return new ResponseEntity<List<Paciente>>(Pacientes, HttpStatus.CONFLICT);
	}
	
	
	@PostMapping(produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Paciente> addPaciente(@RequestBody Paciente paciente) {
		
       return new ResponseEntity<Paciente>(pacienteRepository.save(paciente), HttpStatus.CREATED);
	}

}
