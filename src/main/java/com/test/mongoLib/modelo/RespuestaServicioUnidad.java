package com.test.mongoLib.modelo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.mongoLib.EntidadesMongo.UbicacionUnidades;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespuestaServicioUnidad {

	@JsonProperty("records")
	private List<Contenido<UbicacionUnidades>> respuesta;

	public RespuestaServicioUnidad() {
	}

	public List<Contenido<UbicacionUnidades>> getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(List<Contenido<UbicacionUnidades>> respuesta) {
		this.respuesta = respuesta;
	}
}