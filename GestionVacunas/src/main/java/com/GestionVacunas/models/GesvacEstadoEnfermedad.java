package com.GestionVacunas.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the gesvac_estado_enfermedad database table.
 * 
 */
@Entity
@Table(name="gesvac_estado_enfermedad")
@NamedQuery(name="GesvacEstadoEnfermedad.findAll", query="SELECT g FROM GesvacEstadoEnfermedad g")
public class GesvacEstadoEnfermedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GESVAC_ESTADO_ENFERMEDAD_ID_GENERATOR", sequenceName="SEQ_GESVAC_ESTADO_ENFERMEDAD",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GESVAC_ESTADO_ENFERMEDAD_ID_GENERATOR")
	private long id;

	private String descripcion;

	//bi-directional many-to-one association to GesvacPersonaEnfermedad
	@OneToMany(mappedBy="gesvacEstadoEnfermedad")
	@JsonIgnore
	private List<GesvacPersonaEnfermedad> gesvacPersonaEnfermedads;

	public GesvacEstadoEnfermedad() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<GesvacPersonaEnfermedad> getGesvacPersonaEnfermedads() {
		return this.gesvacPersonaEnfermedads;
	}

	public void setGesvacPersonaEnfermedads(List<GesvacPersonaEnfermedad> gesvacPersonaEnfermedads) {
		this.gesvacPersonaEnfermedads = gesvacPersonaEnfermedads;
	}

	public GesvacPersonaEnfermedad addGesvacPersonaEnfermedad(GesvacPersonaEnfermedad gesvacPersonaEnfermedad) {
		getGesvacPersonaEnfermedads().add(gesvacPersonaEnfermedad);
		gesvacPersonaEnfermedad.setGesvacEstadoEnfermedad(this);

		return gesvacPersonaEnfermedad;
	}

	public GesvacPersonaEnfermedad removeGesvacPersonaEnfermedad(GesvacPersonaEnfermedad gesvacPersonaEnfermedad) {
		getGesvacPersonaEnfermedads().remove(gesvacPersonaEnfermedad);
		gesvacPersonaEnfermedad.setGesvacEstadoEnfermedad(null);

		return gesvacPersonaEnfermedad;
	}

}