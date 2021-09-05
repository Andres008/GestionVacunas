package com.GestionVacunas.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the gesvac_dosis database table.
 * 
 */
@Entity
@Table(name="gesvac_dosis")
@NamedQuery(name="GesvacDosi.findAll", query="SELECT g FROM GesvacDosi g")
public class GesvacDosi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GESVAC_DOSIS_ID_GENERATOR", sequenceName="SEQ_GESVAC_DOSIS",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GESVAC_DOSIS_ID_GENERATOR")
	private long id;

	@Column(name="centro_vacunacion")
	private String centroVacunacion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String lote;

	private String vacunador;

	//bi-directional many-to-one association to GesvacPersona
	@ManyToOne
	@JoinColumn(name="cedula")
	@JsonIgnore
	private GesvacPersona gesvacPersona;

	//bi-directional many-to-one association to GesvacVacuna
	@ManyToOne
	@JoinColumn(name="id_vacuna")
	private GesvacVacuna gesvacVacuna;

	public GesvacDosi() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCentroVacunacion() {
		return this.centroVacunacion;
	}

	public void setCentroVacunacion(String centroVacunacion) {
		this.centroVacunacion = centroVacunacion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getLote() {
		return this.lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getVacunador() {
		return this.vacunador;
	}

	public void setVacunador(String vacunador) {
		this.vacunador = vacunador;
	}

	public GesvacPersona getGesvacPersona() {
		return this.gesvacPersona;
	}

	public void setGesvacPersona(GesvacPersona gesvacPersona) {
		this.gesvacPersona = gesvacPersona;
	}

	public GesvacVacuna getGesvacVacuna() {
		return this.gesvacVacuna;
	}

	public void setGesvacVacuna(GesvacVacuna gesvacVacuna) {
		this.gesvacVacuna = gesvacVacuna;
	}

}