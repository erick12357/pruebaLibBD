package com.test.mongoLib.formas;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forma {

	@JsonProperty("type")
	private String tipo;

	@JsonProperty("coordinates")
	private Double[][][] coordenadas;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double[][][] getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Double[][][] coordenadas) {
		this.coordenadas = coordenadas;
	}

	public Forma() {
	}

}
