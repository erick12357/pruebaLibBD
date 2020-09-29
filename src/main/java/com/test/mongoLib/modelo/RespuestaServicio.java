package com.test.mongoLib.modelo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.mongoLib.EntidadesMongo.Alcaldia;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespuestaServicio {

	@JsonProperty("records")
	private List<Contenido<Alcaldia>> respuesta;

	public RespuestaServicio() {
	}

	public List<Contenido<Alcaldia>> getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(List<Contenido<Alcaldia>> respuesta) {
		this.respuesta = respuesta;
	}
}
