package com.py.sfc.app.params;

import com.py.sfc.app.entities.Clientes;

public class CargarPuntosParam {
	Clientes cliente;
	Integer montoOperacion;
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public Integer getMontoOperacion() {
		return montoOperacion;
	}
	public void setMontoOperacion(Integer montoOperacion) {
		this.montoOperacion = montoOperacion;
	}
	

}
