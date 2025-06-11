package com.sample.core.domain;

public class Pizza extends GenericEntity implements Pedible {

	private int precio;
	
	private String titulo;
	
	private String descripcion;
	
	public Pizza(int precio, String titulo) {
		super();
		this.precio = precio;
		this.titulo = titulo;
	}
	
	
	public Pizza(int id,int precio, String titulo) {
		super.setId(id);
		this.precio = precio;
		this.titulo = titulo;
	}
	
	public Pizza(int id,int precio,String descripcion, String titulo) {
		super.setId(id);
		this.precio = precio;
		this.titulo = titulo;
		this.descripcion = descripcion;
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
		return  this.getPrecio();
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
