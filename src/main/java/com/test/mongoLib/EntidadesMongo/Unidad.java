package com.test.mongoLib.EntidadesMongo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.mongoLib.crudBeans.MongoInfoDocumento;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Unidad implements MongoInfoDocumento {

	@JsonProperty("vehicle_id")
	private Integer idUnidad;

	@JsonProperty("vehicle_label")
	private String etiqueta;

	public Unidad() {
	}

	public Unidad(Integer idUnidad, String etiqueta) {
		super();
		this.idUnidad = idUnidad;
		this.etiqueta = etiqueta;
	}

	public Integer getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(Integer idUnidad) {
		this.idUnidad = idUnidad;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	@Override
	public String obtenerNombreColeccion() {
		return "unidad";
	}

}