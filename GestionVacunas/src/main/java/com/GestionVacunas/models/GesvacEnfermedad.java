package com.GestionVacunas.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gesvac_enfermedad database table.
 * 
 */
@Entity
@Table(name="gesvac_enfermedad")
@NamedQuery(name="GesvacEnfermedad.findAll", query="SELECT g FROM GesvacEnfermedad g")
public class GesvacEnfermedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GESVAC_ENFERMEDAD_ID_GENERATOR", sequenceName="SEQ_GESVAC_ENFERMEDAD",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GESVAC_ENFERMEDAD_ID_GENERATOR")
	private long id;

	private String enfermedad;

	//bi-directional many-to-one association to GesvacPersonaEnfermedad
	@OneToMany(mappedBy="gesvacEnfermedad")
	private List<GesvacPersonaEnfermedad> gesvacPersonaEnfermedads;

	public GesvacEnfermedad() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEnfermedad() {
		return this.enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public List<GesvacPersonaEnfermedad> getGesvacPersonaEnfermedads() {
		return this.gesvacPersonaEnfermedads;
	}

	public void setGesvacPersonaEnfermedads(List<GesvacPersonaEnfermedad> gesvacPersonaEnfermedads) {
		this.gesvacPersonaEnfermedads = gesvacPersonaEnfermedads;
	}

	public GesvacPersonaEnfermedad addGesvacPersonaEnfermedad(GesvacPersonaEnfermedad gesvacPersonaEnfermedad) {
		getGesvacPersonaEnfermedads().add(gesvacPersonaEnfermedad);
		gesvacPersonaEnfermedad.setGesvacEnfermedad(this);

		return gesvacPersonaEnfermedad;
	}

	public GesvacPersonaEnfermedad removeGesvacPersonaEnfermedad(GesvacPersonaEnfermedad gesvacPersonaEnfermedad) {
		getGesvacPersonaEnfermedads().remove(gesvacPersonaEnfermedad);
		gesvacPersonaEnfermedad.setGesvacEnfermedad(null);

		return gesvacPersonaEnfermedad;
	}

}