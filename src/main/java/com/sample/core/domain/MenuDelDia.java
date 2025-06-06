package com.sample.core.domain;

import com.sample.core.enums.TipoEnum;

public class MenuDelDia extends Menu {

	private Plato plato;
	private Postre postre;
	
	public MenuDelDia(int id, String titulo, int precio, Plato plato, Postre postre) {
		super.setId(id);
		super.setPrecio(precio);
		super.setTitulo(titulo);
		this.plato = plato;
		this.postre = postre;
		super.setTipo(TipoEnum.DELDIA);
	}
	
	public MenuDelDia(String titulo, int precio, Plato plato, Postre postre) {
		super.setPrecio(precio);
		super.setTitulo(titulo);
		this.plato = plato;
		this.postre = postre;
		super.setTipo(TipoEnum.DELDIA);
	}
	
	public Plato getPlato() {
		return plato;
	}
	public void setPlato(Plato plato) {
		this.plato = plato;
	}
	public Postre getPostre() {
		return postre;
	}
	public void setPostre(Postre postre) {
		this.postre = postre;
	}
	

	
	
	
	
	
}
