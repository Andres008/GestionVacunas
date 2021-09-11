package com.GestionVacunas.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.GestionVacunas.models.GesvacVacuna;
import com.GestionVacunas.services.GesvacVacunaService;


@RestController
@RequestMapping("/vacuna")
public class GesvacVacunaController {

	private static final Logger logger = LoggerFactory.getLogger(GesvacPersonaController.class);

	@Autowired
	private GesvacVacunaService gesvacVacunaService;

	public GesvacVacunaController(GesvacVacunaService gesvacVacunaService) {
		super();
		this.gesvacVacunaService = gesvacVacunaService;
	}
	
	@GetMapping(produces = "application/json")
	public List<GesvacVacuna> obtenerAllVacunas() {
		return gesvacVacunaService.listaAllVacunas();
	}
	
	@PostMapping(produces = "application/json")
	public GesvacVacuna ingresarVacuna(@RequestBody @Validated GesvacVacuna objGesvacVacuna) {
		
		return gesvacVacunaService.guardarVacuna(objGesvacVacuna);
	}
	
	@PutMapping(produces = "application/json")
	public GesvacVacuna actualizarVacuna(@RequestBody @Validated GesvacVacuna objGesvacVacuna) {
		
		return gesvacVacunaService.guardarVacuna(objGesvacVacuna);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public boolean eliminarVacuna(@RequestBody @Validated GesvacVacuna objGesvacVacuna) throws Exception {
		try {
			gesvacVacunaService.eliminarVacuna(objGesvacVacuna);
			return true;
		} catch (Exception e) {
			logger.info("Error en el consumo del servicio guardar Rol. " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}
}
