package com.py.sfc.app.base;

public class Respuesta <T> {
	private T dato; 
	private String mensaje;
	private Boolean exitoso;
	public T getDato() {
		return dato;
	}
	public void setDato(T dato) {
		this.dato = dato;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Boolean getExitoso() {
		return exitoso;
	}
	public void setExitoso(Boolean exitoso) {
		this.exitoso = exitoso;
	}
	

}
