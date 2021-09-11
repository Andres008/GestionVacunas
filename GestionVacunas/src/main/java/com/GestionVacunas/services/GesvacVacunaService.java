package com.GestionVacunas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionVacunas.models.GesvacVacuna;
import com.GestionVacunas.repository.GesvacVacunaRepository;

@Service
public class GesvacVacunaService {

	@Autowired
	private GesvacVacunaRepository vacunaRepository;
	
	public List<GesvacVacuna> listaAllVacunas(){
		return (List<GesvacVacuna>) vacunaRepository.findAll();
	}

	public GesvacVacuna guardarVacuna(GesvacVacuna objGesvacVacuna) {
		return vacunaRepository.save(objGesvacVacuna);
	}
	
	public void eliminarVacuna(GesvacVacuna objGesvacVacuna) {
		vacunaRepository.delete(objGesvacVacuna);
	}
	
	
	
}
