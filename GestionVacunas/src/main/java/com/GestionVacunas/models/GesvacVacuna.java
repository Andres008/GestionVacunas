package com.GestionVacunas.models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the gesvac_vacuna database table.
 * 
 */
@Entity
@Table(name="gesvac_vacuna")
@NamedQuery(name="GesvacVacuna.findAll", query="SELECT g FROM GesvacVacuna g")
public class GesvacVacuna implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GESVAC_VACUNA_ID_GENERATOR", sequenceName="SEQ_GESVAC_VACUNA", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GESVAC_VACUNA_ID_GENERATOR")
	private long id;

	private BigDecimal cantidad;

	private String estado;

	private String marca;

	//bi-directional many-to-one association to GesvacDosi
	@OneToMany(mappedBy="gesvacVacuna")
	private List<GesvacDosi> gesvacDosis;

	public GesvacVacuna() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public List<GesvacDosi> getGesvacDosis() {
		return this.gesvacDosis;
	}

	public void setGesvacDosis(List<GesvacDosi> gesvacDosis) {
		this.gesvacDosis = gesvacDosis;
	}

	public GesvacDosi addGesvacDosi(GesvacDosi gesvacDosi) {
		getGesvacDosis().add(gesvacDosi);
		gesvacDosi.setGesvacVacuna(this);

		return gesvacDosi;
	}

	public GesvacDosi removeGesvacDosi(GesvacDosi gesvacDosi) {
		getGesvacDosis().remove(gesvacDosi);
		gesvacDosi.setGesvacVacuna(null);

		return gesvacDosi;
	}

}