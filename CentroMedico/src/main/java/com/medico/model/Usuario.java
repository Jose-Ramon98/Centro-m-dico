package com.medico.model;

public class Usuario {

	private String nombre;
	private String apellido;
	private Integer SIP;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getSIP() {
		return SIP;
	}
	
	public void setSIP(Integer sIP) {
		SIP = sIP;
	}
	public Usuario() {
		super();
	}
	public Usuario(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

}

