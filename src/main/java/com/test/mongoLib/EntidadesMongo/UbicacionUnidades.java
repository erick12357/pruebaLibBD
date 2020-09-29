package com.test.mongoLib.EntidadesMongo;

import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.mongoLib.crudBeans.MongoInfoDocumento;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UbicacionUnidades implements MongoInfoDocumento {

	@JsonProperty("vehicle_id")
	private Integer idUnidad;

	@JsonProperty("vehicle_label")
	private String etiqueta;

	@JsonProperty("vehicle_current_status")
	private String status;

	@JsonProperty("position_speed")
	private Double velocidad;
	@JsonProperty("position_latitude")
	private Double latitud;
	@JsonProperty("position_longitude")
	private Double longitud;

	private Double[] ubicacion;

	private LocalDateTime horaConsulta;

	public UbicacionUnidades() {
		this.horaConsulta = LocalDateTime.now();
	}

	public Integer getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(Integer idUnidad) {
		this.idUnidad = idUnidad;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Double velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public String obtenerNombreColeccion() {
		return "ubicacion";
	}

	public LocalDateTime getHoraConsulta() {
		return horaConsulta;
	}

	public void setHoraConsulta(LocalDateTime horaConsulta) {
		this.horaConsulta = horaConsulta;
	}

	public Double[] getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Double[] ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void fijarPunto() {
		this.ubicacion = new Double[] { this.longitud, this.latitud };
	}

}
