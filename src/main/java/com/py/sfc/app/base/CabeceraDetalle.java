package com.py.sfc.app.base;

import java.util.List;

public class CabeceraDetalle <T,V> {
	public T cabecera;
	public List<V>  detalle;
	
	
	public T getCabecera() {
		return cabecera;
	}
	public void setCabecera(T cabecera) {
		this.cabecera = cabecera;
	}
	public List<V> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<V> detalle) {
		this.detalle = detalle;
	}
	
	
	
}
