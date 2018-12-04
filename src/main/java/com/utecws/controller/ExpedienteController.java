package com.utecws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utecws.entity.Expediente;
import com.utecws.entity.Expediente;
import com.utecws.repository.ExpedienteRepository;

@RestController
@RequestMapping("/expediente")
public class ExpedienteController {
	
	@Autowired
	private ExpedienteRepository expedienteRepository;
	
	@PostMapping(produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Expediente> addExpediente(@RequestBody Expediente expediente) {
		
       return new ResponseEntity<Expediente>(expedienteRepository.save(expediente), HttpStatus.CREATED);
	}

	
	@GetMapping(produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Expediente>> getExpedientes() {
		
        
		List<Expediente> Expediente = expedienteRepository.findAll();
                
        if (!Expediente.isEmpty()) {
                	
              return new ResponseEntity<List<Expediente>>(Expediente, HttpStatus.OK);
          }
        
       return new ResponseEntity<List<Expediente>>(Expediente, HttpStatus.CONFLICT);
	
	}
	
	
	@GetMapping(value = "/{duiPaciente}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Expediente> getExpediente(@PathVariable String duiPaciente) {
		
        
		Expediente expediente = expedienteRepository.getExpedienteByDuiPaciente(duiPaciente);   
       return new ResponseEntity<Expediente>(expediente, HttpStatus.OK);
	
	}
	
	@PutMapping(value = "/{duiPaciente}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Expediente> updateExpediente(@PathVariable String duiPaciente,
													@RequestBody Expediente expediente) {
		
		Expediente c = expedienteRepository.getExpedienteByDuiPaciente(duiPaciente);
		
		if (expediente.getAlergias() != null) {
			c.setAlergias(expediente.getAlergias());
		}
		
		if (expediente.getNombres() != null) {
			
			c.setNombres(expediente.getNombres());
		}


		if (expediente.getApellidos() != null) {
			
			c.setApellidos(expediente.getApellidos());
		}
		
		if (expediente.getCorreo() != null) {
			
			c.setCorreo(expediente.getCorreo() );
		}
		
		if (expediente.getDomicilio() != null) {
			expediente.setDomicilio(expediente.getDomicilio());
		}
		
		
		if (expediente.getFecha_nacimiento() != null) {
			expediente.setFecha_nacimiento(expediente.getFecha_nacimiento());
		}
		
		if (expediente.getLugar_nacimiento() != null) {
			expediente.setLugar_nacimiento(expediente.getLugar_nacimiento());
		}
		
		
		if (expediente.getGenero() != null) {
			expediente.setGenero(expediente.getGenero());
		}
		
		if (expediente.getTelefono() != null) {
			expediente.setTelefono(expediente.getTelefono());
		}
		
		if (expediente.getObservaciones() != null) {
			expediente.setObservaciones(expediente.getObservaciones());
		}
		
		if (expediente.getOcupacion() != null) {
			expediente.setOcupacion(expediente.getOcupacion());
		}
		
		
       return new ResponseEntity<Expediente>(expedienteRepository.save(c), HttpStatus.CREATED);
	}
	
	
	
}
