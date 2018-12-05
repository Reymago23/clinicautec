package com.utecws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utecws.entity.Enfermera;
import com.utecws.entity.Medico;
import com.utecws.entity.Paciente;
import com.utecws.repository.EnfermeraRepository;
import com.utecws.repository.MedicoRepository;
import com.utecws.repository.PacienteRepository;

@RestController
public class LoginController {

	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private EnfermeraRepository enfermeraRepository;
	
	
	@GetMapping(value = "paciente/{dui}/{clave}", produces= { MediaType.APPLICATION_JSON_VALUE } ) 
	public ResponseEntity<Paciente> getPacienteLogin(@PathVariable String dui, @PathVariable String clave ) {
		
	   Paciente paciente = pacienteRepository.getPacienteByDuiAndClave(dui, clave);
	   
       return new ResponseEntity<Paciente>(paciente , HttpStatus.OK);
     
	}
	
	@GetMapping(value = "medico/{dui}/{clave}", produces= { MediaType.APPLICATION_JSON_VALUE } ) 
	public ResponseEntity<Medico> getMedicoLogin(@PathVariable String dui, @PathVariable String clave ) {
		
	   Medico medico = medicoRepository.getMedicoByDuiAndClave(dui, clave);
	   
       return new ResponseEntity<Medico>(medico , HttpStatus.OK);
     
	}
	
	
	@GetMapping(value = "enfermera/{dui}/{clave}", produces= { MediaType.APPLICATION_JSON_VALUE } ) 
	public ResponseEntity<Enfermera> getEnfermeraLogin(@PathVariable String dui, @PathVariable String clave ) {
		
	   Enfermera enfermera = enfermeraRepository.getEnfermeraByDuiAndClave(dui, clave);
	   
       return new ResponseEntity<Enfermera>(enfermera , HttpStatus.OK);
     
	}
}
