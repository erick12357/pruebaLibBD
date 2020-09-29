package com.test.mongoLib.crudBeans;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoJsonPolygon;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.test.mongoLib.EntidadesMongo.Alcaldia;
import com.test.mongoLib.EntidadesMongo.UbicacionUnidades;
import com.test.mongoLib.EntidadesMongo.Unidad;

public class MongoCrud {

	private MongoTemplate template;

	public MongoCrud(MongoTemplate template) {
		this.template = template;
	}

	public void guardarDocumento(MongoInfoDocumento documento) {
		template.save(documento, documento.obtenerNombreColeccion());
	}

	public void guardarDocumentos(List<MongoInfoDocumento> documentos) {
		for (MongoInfoDocumento documento : documentos) {
			guardarDocumento(documento);
		}
	}

	/**
	 * Elimina la coleccion que coincida con el nombre en el parametro
	 * @param String nombre de la coleccion a eliminar
	 * */
	public void borrarColeccion(String coleccion) {
		template.dropCollection(coleccion);
	}

	/**
	 * Regresa una lista con todas las alcaldias registradas 
	 * */
	public List<Alcaldia> alcaldiaObtenerTodo() {
		return template.findAll(Alcaldia.class, "alcaldia");
	}

	/**
	 * Regresa los registros de una unidad 
	 * @param Entero, id de la unidad a buscar
	 * 
	 * */
	public List<UbicacionUnidades> seguimientoUnidad(Integer id) {
		Query query = new Query();

		query.addCriteria(Criteria.where("idUnidad").is(id));
		query.addCriteria(Criteria.where("horaConsulta").gte(LocalDateTime.now().minusHours(1)));

		return template.find(query, UbicacionUnidades.class, "ubicacion");
	}

	/**
	 * Regresa una lista de todas las unidades de metrobus registradas
	 * */
	public List<Unidad> unidadObtenerTodo() {
		return template.findAll(Unidad.class, "unidad");
	}
	/**
	 * Regresa un Optional que puede contener un Objeto Alcaldia 
	 * @param idAlcaldia, entero
	 * @return Optional<Alcaldia>
	 * */
	public Optional<Alcaldia> obtenerAlcaldia(Integer idAlcaldia) {
		Alcaldia alcaldia = template.findOne(new Query().addCriteria(Criteria.where("idAlcaldia").is(idAlcaldia)),
				Alcaldia.class);

		if (alcaldia == null) {
			return Optional.empty();
		}

		return Optional.of(alcaldia);
	}

	public Optional<List<UbicacionUnidades>> obtenerUnidadesAlcaldia(Double[][] coordenadas) {

		List<Point> posiciones = new ArrayList<>();

		for (Double[] position : coordenadas) {
			posiciones.add(new Point(position[0], position[1]));
		}

		GeoJsonPolygon geoJsonPolygon = new GeoJsonPolygon(posiciones);

		Query query = Query.query(Criteria.where("ubicacion").within(geoJsonPolygon));

		List<UbicacionUnidades> unidades = template.find(query, UbicacionUnidades.class,"ubicacion");

		if (unidades.isEmpty()) {
			return Optional.empty();
		}

		return Optional.of(unidades);
	}
}
