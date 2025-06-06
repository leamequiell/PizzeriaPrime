package com.sample.core.domain;

import com.sample.core.enums.TipoEnum;

public class Menu extends GenericEntity implements Pedible {

	private String titulo;
	
	private int precio;
	
	private String descripcion;

	private TipoEnum tipo;

	public Menu() {
		
	}
	public Menu(int id , String titulo, int precio, String descripcion, TipoEnum tipo) {
		super.setId(id);
		this.titulo = titulo;
		this.precio = precio;
		this.descripcion = descripcion;
		this.tipo = tipo;
	}

	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
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
