package com.py.sfc.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.py.sfc.app.base.Globales;
import com.py.sfc.app.base.PaginadoParam;
import com.py.sfc.app.base.PaginadoResult;
import com.py.sfc.app.base.Respuesta;
import com.py.sfc.app.entities.VencimientoPuntos;
import com.py.sfc.app.services.VencimientoPuntosService;

@RestController
@RequestMapping(value = "/vencimiento-puntos")
@CrossOrigin(origins = "*")
public class VencimientoPuntosController {

	@Autowired
	private VencimientoPuntosService service;

	@PostMapping(path = "/paginado")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> listarPaginado(@RequestBody PaginadoParam<VencimientoPuntos> param) {
		try {
			PaginadoResult<VencimientoPuntos> lista = service.listarPaginado(param);
			return new ResponseEntity<PaginadoResult<?>>(lista, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}

	@PostMapping("/")
	public ResponseEntity<?> agregarRecurso(@RequestBody VencimientoPuntos param) {
		Respuesta<VencimientoPuntos> respuesta = new Respuesta<>();

		try {
			VencimientoPuntos dato = service.insertarSinClavePrimaria(param);
			respuesta.setDato(dato);
			respuesta.setMensaje(Globales.MensajeCRUD.MENSAJE_AGREGAR);
			respuesta.setExitoso(true);
			return new ResponseEntity<Respuesta<?>>(respuesta, HttpStatus.CREATED);

		} catch (Exception e) {
			respuesta.setMensaje(e.getMessage());
			respuesta.setExitoso(false);
			return new ResponseEntity<Respuesta<?>>(respuesta, HttpStatus.CONFLICT);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> modificarRecurso(@PathVariable("id") Integer id, @RequestBody VencimientoPuntos param) {
		Respuesta<VencimientoPuntos> respuesta = new Respuesta<>();
		try {
			param.setVencimientoPunto(id);
			service.modificar(param);
			respuesta.setDato(null);
			respuesta.setMensaje(Globales.MensajeCRUD.MENSAJE_MODIFICAR);
			respuesta.setExitoso(true);
			return new ResponseEntity<Respuesta<?>>(respuesta, HttpStatus.OK);

		} catch (Exception e) {
			respuesta.setMensaje(e.getMessage());
			respuesta.setExitoso(false);
			return new ResponseEntity<Respuesta<?>>(respuesta, HttpStatus.CONFLICT);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerRecurso(@PathVariable("id") Integer id) {
		Respuesta<VencimientoPuntos> respuesta = new Respuesta<>();

		try {
			VencimientoPuntos dato = service.obtener(id);
			
			if (dato == null) {
				respuesta.setMensaje(Globales.MensajeCRUD.MENSAJE_OBTENER_ERROR);
				respuesta.setExitoso(false);
				return new ResponseEntity<Respuesta<?>>(respuesta, HttpStatus.NOT_FOUND);
			}
			respuesta.setDato(dato);
			respuesta.setMensaje(Globales.MensajeCRUD.MENSAJE_OBTENER);
			respuesta.setExitoso(true);
			return new ResponseEntity<Respuesta<?>>(respuesta, HttpStatus.OK);

		} catch (Exception e) {
			respuesta.setMensaje(e.getMessage());
			respuesta.setExitoso(false);
			return new ResponseEntity<Respuesta<?>>(respuesta, HttpStatus.CONFLICT);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarRecurso(@PathVariable("id") Integer id) {
		Respuesta<VencimientoPuntos> respuesta = new Respuesta<>();

		try {
			service.eliminar(id);
			respuesta.setMensaje(Globales.MensajeCRUD.MENSAJE_ELIMINAR);
			respuesta.setExitoso(true);
			return new ResponseEntity<Respuesta<?>>(respuesta, HttpStatus.OK);

		} catch (Exception e) {
			respuesta.setMensaje(e.getMessage());
			respuesta.setExitoso(false);
			return new ResponseEntity<Respuesta<?>>(respuesta, HttpStatus.CONFLICT);
		}

	}

	@GetMapping("/")
	public ResponseEntity<?> listar() {
		Respuesta<List<VencimientoPuntos>> respuesta = new Respuesta<>();
		List<VencimientoPuntos> dato = new ArrayList<VencimientoPuntos>();
		try {
			dato = service.listar();
			if (dato == null) {
				respuesta.setDato(dato);
				respuesta.setMensaje(Globales.MensajeCRUD.MENSAJE_OBTENER_ERROR);
				respuesta.setExitoso(false);
				return new ResponseEntity<Respuesta<?>>(respuesta, HttpStatus.NOT_FOUND);
			}

			respuesta.setDato(dato);
			respuesta.setExitoso(true);
			return new ResponseEntity<Respuesta<?>>(respuesta, HttpStatus.OK);

		} catch (Exception e) {
			respuesta.setMensaje(e.getMessage());
			respuesta.setExitoso(false);
			return new ResponseEntity<Respuesta<?>>(respuesta, HttpStatus.CONFLICT);
		}

	}

}
