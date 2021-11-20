package com.py.sfc.app.params;

import java.util.Date;

import com.py.sfc.app.entities.Clientes;

public class BolsasConsultaParam {
	Clientes cliente;
	Integer montoIni;
	Integer montoFin;
	/**
	 * @return the cliente
	 */
	public Clientes getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the montoIni
	 */
	public Integer getMontoIni() {
		return montoIni;
	}
	/**
	 * @param montoIni the montoIni to set
	 */
	public void setMontoIni(Integer montoIni) {
		this.montoIni = montoIni;
	}
	/**
	 * @return the montoFin
	 */
	public Integer getMontoFin() {
		return montoFin;
	}
	/**
	 * @param montoFin the montoFin to set
	 */
	public void setMontoFin(Integer montoFin) {
		this.montoFin = montoFin;
	}
	
	
}
