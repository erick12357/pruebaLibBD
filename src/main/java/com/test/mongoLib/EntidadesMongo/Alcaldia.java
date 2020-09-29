package com.test.mongoLib.EntidadesMongo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.mongoLib.crudBeans.MongoInfoDocumento;
import com.test.mongoLib.formas.Forma;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Alcaldia implements MongoInfoDocumento {

	@JsonProperty("gid")
	private Integer idAlcaldia;

	@JsonProperty("nomgeo")
	private String nombre;

	@JsonProperty("geo_shape")
	private Forma forma;

	/*@JsonProperty("geo_shape")
	private GeoJsonPolygon poligono;*/

	public Alcaldia() {
	}

	@Override
	public String obtenerNombreColeccion() {
		return "alcaldia";
	}

	public Integer getIdAlcaldia() {
		return idAlcaldia;
	}

	public void setIdAlcaldia(Integer idAlcaldia) {
		this.idAlcaldia = idAlcaldia;
	}

	public Forma getForma() {
		return forma;
	}

	public void setForma(Forma forma) {
		this.forma = forma;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*public GeoJsonPolygon getPoligono() {
		return poligono;
	}

	public void setPoligono(GeoJsonPolygon poligono) {
		this.poligono = poligono;
	}*/

	@Override
	public String toString() {
		return "Alcaldia [id=" + idAlcaldia + ", nombre=" + nombre + "]";
	}

}
