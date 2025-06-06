package com.sample.core.domain;

public class Postre extends GenericEntity implements  Pedible{

	private int precio;
	
	private String titulo;
	
	private String descripcion;
	
	public Postre(int id,String titulo, int precio,String descripcion) {
		super.setId(id);
		this.titulo = titulo;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	
	
	public Postre(int precio, String titulo) {
		super();
		this.precio = precio;
		this.titulo = titulo;
	}
	
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
	public int damePrecio() {
		return this.getPrecio();
	}
	
	public String dameTitulo() {
		return this.getTitulo();
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
