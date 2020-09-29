package com.test.mongoLib.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Contenido<T> {

	@JsonProperty("fields")
	T campos;

	public T getCampos() {
		return campos;
	}

	public void setCampos(T campos) {
		this.campos = campos;
	}

	public Contenido() {
	}

}