package com.py.sfc.app.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.py.sfc.app.entities.BolsaPuntos;
import com.py.sfc.app.entities.Clientes;

@Service
public class ConsultasServices {
	@Autowired
	private BolsaPuntosService bservice;
	public void obtenerPuntos() {}
	public List<Clientes> obtenerClientes(Integer cantDias) {
		Date hoy = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(hoy);
		cal.add(Calendar.DATE, cantDias);
		List<Clientes> listaC = bservice.clientesConPuntosVenc(hoy, cal.getTime());
		
		return listaC;
		
	}
	public List<BolsaPuntos> bolsaDePuntos(Integer cliente,Integer ini, Integer fin) {
		return bservice.bolsasConsulta(cliente, ini, fin);
	}

}
