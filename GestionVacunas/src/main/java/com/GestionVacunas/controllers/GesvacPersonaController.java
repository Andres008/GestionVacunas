package com.GestionVacunas.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionVacunas.models.GesvacPersona;
import com.GestionVacunas.services.GesvacPersonaServices;

@RestController
@RequestMapping("/persona")
public class GesvacPersonaController {

	private static final Logger logger = LoggerFactory.getLogger(GesvacPersonaController.class);

	private GesvacPersonaServices gesvacPersonaServices;

	public GesvacPersonaController(GesvacPersonaServices gesvacPersonaServices) {
		super();
		this.gesvacPersonaServices = gesvacPersonaServices;
	}

	@GetMapping(produces = "application/json")
	public List<GesvacPersona> obtenerAllPersonas() {
		return gesvacPersonaServices.obtenerTodosPersona();
	}

	@PostMapping(produces = "application/json")
	public GesvacPersona ingresarPersona(@RequestBody @Validated GesvacPersona objGesvacPersona) {
		objGesvacPersona.getGesvacPersonaEnfermedads()
				.forEach(enfermedad -> enfermedad.setGesvacPersona(objGesvacPersona));
		System.out.println(objGesvacPersona);
		return gesvacPersonaServices.guardarPersona(objGesvacPersona);
	}

}
