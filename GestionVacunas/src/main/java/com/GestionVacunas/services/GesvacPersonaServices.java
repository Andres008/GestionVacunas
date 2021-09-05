package com.GestionVacunas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionVacunas.models.GesvacPersona;
import com.GestionVacunas.repository.GesvacPersonaRepository;

@Service
public class GesvacPersonaServices {
	
	@Autowired
	private GesvacPersonaRepository gesvacPersonaRepository; 
	
	public List<GesvacPersona> obtenerTodosPersona(){
		return (List<GesvacPersona>) gesvacPersonaRepository.findAll();
	}
	
	public GesvacPersona guardarPersona( GesvacPersona objGesvacPersona ) {
		return gesvacPersonaRepository.save(objGesvacPersona);
	}
	
	public void elminarPersona(GesvacPersona objGesvacPersona) {
		gesvacPersonaRepository.delete(objGesvacPersona);
	}

}
