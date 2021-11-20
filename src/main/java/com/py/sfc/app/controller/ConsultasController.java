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
import com.py.sfc.app.entities.AsignacionPuntos;
import com.py.sfc.app.entities.BolsaPuntos;
import com.py.sfc.app.entities.Clientes;
import com.py.sfc.app.entities.ConceptoPuntos;
import com.py.sfc.app.entities.UsoPuntos;
import com.py.sfc.app.params.BolsasConsultaParam;
import com.py.sfc.app.services.ClientesService;
import com.py.sfc.app.services.ConsultasServices;
import com.py.sfc.app.services.UsoPuntosService;

@RestController
@RequestMapping(value = "/consultas")
@CrossOrigin(origins = "*")
public class ConsultasController {

	@Autowired
	private ConsultasServices service;
	
	@Autowired
	private UsoPuntosService usoService;

	@GetMapping(path = "/puntos-vencer/{cantDias}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> listarPaginado(@PathVariable("cantDias") Integer cantDias) {
		try {
			List<BolsaPuntos> lista = service.obtenerClientes(cantDias);
			return new ResponseEntity<List<BolsaPuntos>>(lista, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}

	@PostMapping(path = "/bolsas/")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> bolsaPuntos(@RequestBody BolsasConsultaParam param) {
		try {
			List<BolsaPuntos> lista = service.bolsaDePuntos(param.getCliente().getCliente(),param.getMontoIni(),param.getMontoFin());
			return new ResponseEntity<List<BolsaPuntos>>(lista, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping(path = "/puntos/")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> bolsaPuntos( @RequestBody UsoPuntos param) {
		try {
		
			List<UsoPuntos> lista = usoService.listarByExample(param);
			return new ResponseEntity<List<UsoPuntos>>(lista, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
	}

}
