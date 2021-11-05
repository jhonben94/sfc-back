package com.py.sfc.app.params;

import com.py.sfc.app.entities.Clientes;
import com.py.sfc.app.entities.ConceptoPuntos;

public class UsarPuntosParam {
	Clientes cliente;
	ConceptoPuntos concepto;
	Integer puntosUtilizados;
	
	
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public ConceptoPuntos getConcepto() {
		return concepto;
	}
	public void setConcepto(ConceptoPuntos concepto) {
		this.concepto = concepto;
	}
	public Integer getPuntosUtilizados() {
		return puntosUtilizados;
	}
	public void setPuntosUtilizados(Integer puntosUtilizados) {
		this.puntosUtilizados = puntosUtilizados;
	}
	

}
