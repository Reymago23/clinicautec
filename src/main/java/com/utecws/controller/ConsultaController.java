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

import com.utecws.entity.Consulta;
import com.utecws.repository.ConsultaRepository;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	
	@GetMapping(value = "/{fecha}/{hora}", produces= { MediaType.APPLICATION_JSON_VALUE } ) 
	public ResponseEntity<Long> getCountByFechaAndHora(@PathVariable String fecha, 
																@PathVariable String hora ) {
		
		long count = consultaRepository.countDistinctByFechaAndHora(fecha, hora);
       return new ResponseEntity<Long>(count , HttpStatus.OK);
     }
	
	@GetMapping(value = "/medico/{dui}", produces= { MediaType.APPLICATION_JSON_VALUE } ) 
	public ResponseEntity<List<Consulta>> getConsultasByDuiMedico(@PathVariable String dui) {
		
		List<Consulta> consultas = consultaRepository.getConsultasByDuiMedico(dui);
       return new ResponseEntity<List<Consulta>>(consultas , HttpStatus.OK);
     }
	
	@GetMapping(value = "/paciente/{dui}", produces= { MediaType.APPLICATION_JSON_VALUE } ) 
	public ResponseEntity<List<Consulta>> getConsultasByDuiPaciente(@PathVariable String dui) {
		
		List<Consulta> consultas = consultaRepository.getConsultasByDuiPaciente(dui);
       return new ResponseEntity<List<Consulta>>(consultas , HttpStatus.OK);
     }
	
	@GetMapping(value = "/{estado}", produces= { MediaType.APPLICATION_JSON_VALUE } ) 
	public ResponseEntity<List<Consulta>> getConsultasByEstado(@PathVariable int estado) {
		
		List<Consulta> consultas = consultaRepository.getConsultasByEstadoConsulta(estado);
       return new ResponseEntity<List<Consulta>>(consultas , HttpStatus.OK);
     }
	
	
	@GetMapping(produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Consulta>> getConsultas() {
		
        
		List<Consulta> consultas = consultaRepository.findAll();
                
        if (!consultas.isEmpty()) {
                	
              return new ResponseEntity<List<Consulta>>(consultas, HttpStatus.OK);
          }
        
       return new ResponseEntity<List<Consulta>>(consultas, HttpStatus.CONFLICT);
	}
	
	
	@PostMapping(produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Consulta> addConsulta(@RequestBody Consulta consulta) {
		
       return new ResponseEntity<Consulta>(consultaRepository.save(consulta), HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/{duiPaciente}/{estado}/{fecha}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Consulta> updateConsulta(@PathVariable String duiPaciente,
													@PathVariable int estado,
													@PathVariable String fecha,
													@RequestBody Consulta consulta) {
		
		Consulta c = consultaRepository
				.getConsultaByDuiPacienteAndEstadoConsultaAndFecha(duiPaciente, estado,  fecha);
		
		if (consulta.getDuiMedico() != null) {
			c.setDuiMedico(consulta.getDuiMedico());
		}
		
		if (consulta.getFecha() != null) {
			
			c.setFecha(consulta.getFecha());
		}
		
		if (consulta.getRazonConsulta() != null) {
			
			c.setRazonConsulta(consulta.getRazonConsulta());
		}
		
		if (consulta.getSintomas() != null) {
			
			c.setSintomas(consulta.getSintomas());
		}
		
		
		c.setEstadoConsulta(consulta.getEstadoConsulta());
		
       return new ResponseEntity<Consulta>(consultaRepository.save(c), HttpStatus.OK);
	}
	
	
	

}
