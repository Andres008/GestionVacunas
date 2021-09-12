package com.GestionVacunas.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.GestionVacunas.Utils.ModelUtil;
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
	public String ingresarPersona(@RequestBody @Validated GesvacPersona objGesvacPersona) throws Exception {
		try {
			validacionDatosPersona(objGesvacPersona);
			objGesvacPersona.getGesvacPersonaEnfermedads()
					.forEach(enfermedad -> enfermedad.setGesvacPersona(objGesvacPersona));
			gesvacPersonaServices.guardarPersona(objGesvacPersona);
			return "100";
		} catch (Exception e) {
			logger.info("Error en el consumo del servicio guardar Persona. " + e.getMessage());
			return e.getMessage();
		}
		/*
		 * objGesvacPersona.getGesvacPersonaEnfermedads() .forEach(enfermedad ->
		 * enfermedad.setGesvacPersona(objGesvacPersona));
		 */
	}

	private void validacionDatosPersona(GesvacPersona objGesvacPersona) throws Exception {
		ModelUtil.verificarCedulaEcuador(objGesvacPersona.getCedula());
		ModelUtil.esEmailCorrecto(objGesvacPersona.getCorreoElectronico());
		if (!ModelUtil.esSoloLetras(objGesvacPersona.getApellidos()))
			throw new Exception("101");
		if (!ModelUtil.esSoloLetras(objGesvacPersona.getNombres()))
			throw new Exception("102");
		if (ModelUtil.verificarFechaNull(objGesvacPersona.getFechaNacimiento()))
			throw new Exception("103");
		if (ModelUtil.verificarStringVacio(objGesvacPersona.getCedula()))
			throw new Exception("104");
		if (ModelUtil.verificarStringVacio(objGesvacPersona.getApellidos()))
			throw new Exception("105");
		if (ModelUtil.verificarStringVacio(objGesvacPersona.getNombres()))
			throw new Exception("106");
		if (ModelUtil.verificarStringVacio(objGesvacPersona.getCorreoElectronico()))
			throw new Exception("107");
		if (ModelUtil.verificarStringVacio(objGesvacPersona.getDirecion()))
			throw new Exception("108");
		if (ModelUtil.verificarStringVacio(objGesvacPersona.getOcupacion()))
			throw new Exception("109");

	}

	@PutMapping(produces = "application/json")
	public GesvacPersona actualizarPersona(@RequestBody @Validated GesvacPersona objGesvacPersona) throws Exception {
		try {
			validacionDatosPersona(objGesvacPersona);
			objGesvacPersona.getGesvacPersonaEnfermedads()
					.forEach(enfermedad -> enfermedad.setGesvacPersona(objGesvacPersona));
			System.out.println(objGesvacPersona);
			return gesvacPersonaServices.guardarPersona(objGesvacPersona);
		} catch (Exception e) {
			logger.info("Error en el consumo del servicio guardar Persona. " + e.getMessage());
			throw new Exception(e.getMessage());
		}

	}

	@RequestMapping(method = RequestMethod.DELETE)
	public boolean eliminarPersona(@RequestBody @Validated GesvacPersona objGesvacPersona) throws Exception {
		try {
			gesvacPersonaServices.elminarPersona(objGesvacPersona);
			return true;
		} catch (Exception e) {
			logger.info("Error en el consumo del servicio eliminar Persona. " + e.getMessage());
			throw new Exception(e.getMessage());
		}

	}

}
