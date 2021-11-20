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
import com.py.sfc.app.entities.BolsaPuntos;
import com.py.sfc.app.entities.Clientes;
import com.py.sfc.app.entities.UsoPuntos;
import com.py.sfc.app.services.ClientesService;
import com.py.sfc.app.services.ConsultasServices;

@RestController
@RequestMapping(value = "/consultas")
@CrossOrigin(origins = "*")
public class ConsultasController {

	@Autowired
	private ConsultasServices service;

	@GetMapping(path = "/puntos-vencer/{cantDias}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> listarPaginado(@PathVariable("cantDias") Integer cantDias) {
		try {
			List<Clientes> lista = service.obtenerClientes(cantDias);
			return new ResponseEntity<List<Clientes>>(lista, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}

	@GetMapping(path = "/bolsas/{cliente}/{ini}/{fin}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> bolsaPuntos(@PathVariable("cliente") Integer cliente,
			@PathVariable("ini") Integer ini,
			@PathVariable("fin") Integer fin) {
		try {
			List<BolsaPuntos> lista = service.bolsaDePuntos(cliente,ini,fin);
			return new ResponseEntity<List<BolsaPuntos>>(lista, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping(path = "/puntos/{cliente}/{concepto}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> bolsaPuntos(@PathVariable("cliente") Integer cliente,
			@PathVariable("concepto") Integer concepto) {
		try {
			List<UsoPuntos> lista = service.obtenerUsoPuntos(cliente,concepto);
			return new ResponseEntity<List<UsoPuntos>>(lista, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}

}
