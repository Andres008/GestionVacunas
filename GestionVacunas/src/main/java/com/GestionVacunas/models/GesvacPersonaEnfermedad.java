package com.GestionVacunas.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the gesvac_persona_enfermedad database table.
 * 
 */
@Entity
@Table(name="gesvac_persona_enfermedad")
@NamedQuery(name="GesvacPersonaEnfermedad.findAll", query="SELECT g FROM GesvacPersonaEnfermedad g")
public class GesvacPersonaEnfermedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GESVAC_PERSONA_ENFERMEDAD_ID_GENERATOR", sequenceName="SEQ_GESVAC_PERSONA_ENFERMEDAD",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GESVAC_PERSONA_ENFERMEDAD_ID_GENERATOR")
	private long id;

	//bi-directional many-to-one association to GesvacEnfermedad
	@ManyToOne
	@JoinColumn(name="id_enfermedad")
	private GesvacEnfermedad gesvacEnfermedad;

	//bi-directional many-to-one association to GesvacEstadoEnfermedad
	@ManyToOne
	@JoinColumn(name="id_estado_enfermedad")
	private GesvacEstadoEnfermedad gesvacEstadoEnfermedad;

	//bi-directional many-to-one association to GesvacPersona
	@ManyToOne
	@JoinColumn(name="cedula")
	@JsonIgnore
	private GesvacPersona gesvacPersona;

	public GesvacPersonaEnfermedad() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public GesvacEnfermedad getGesvacEnfermedad() {
		return this.gesvacEnfermedad;
	}

	public void setGesvacEnfermedad(GesvacEnfermedad gesvacEnfermedad) {
		this.gesvacEnfermedad = gesvacEnfermedad;
	}

	public GesvacEstadoEnfermedad getGesvacEstadoEnfermedad() {
		return this.gesvacEstadoEnfermedad;
	}

	public void setGesvacEstadoEnfermedad(GesvacEstadoEnfermedad gesvacEstadoEnfermedad) {
		this.gesvacEstadoEnfermedad = gesvacEstadoEnfermedad;
	}

	public GesvacPersona getGesvacPersona() {
		return this.gesvacPersona;
	}

	public void setGesvacPersona(GesvacPersona gesvacPersona) {
		this.gesvacPersona = gesvacPersona;
	}

}