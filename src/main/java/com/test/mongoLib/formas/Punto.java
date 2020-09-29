package com.test.mongoLib.formas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Punto {
	
	Double[] coordernadas;

	public Punto(Double[] coordernadas) {
		this.coordernadas = coordernadas;
	}

	public Double[] getCoordernadas() {
		return coordernadas;
	}

	public void setCoordernadas(Double[] coordernadas) {
		this.coordernadas = coordernadas;
	}

}
