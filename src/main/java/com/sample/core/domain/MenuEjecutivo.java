package com.sample.core.domain;

import com.sample.core.enums.TipoEnum;

public class MenuEjecutivo  extends Menu {

	private Plato PLato;
	private Bebida bebida;
	private Postre postre;
	
	
	public MenuEjecutivo(int id, String titulo, int precio,  Plato pLato, Bebida bebida, Postre postre) {
		super.setId(id);
		super.setPrecio(precio);
		super.setTitulo(titulo);
		super.setTipo(TipoEnum.EJECUTIVO);
		this.bebida = bebida;
		this.postre = postre;
		PLato = pLato;
	}
	
	
	
	public MenuEjecutivo( String titulo, int precio,  Plato pLato, Bebida bebida, Postre postre) {
		super.setPrecio(precio);
		super.setTitulo(titulo);
		PLato = pLato;
		this.bebida = bebida;
		this.postre = postre;
		super.setTipo(TipoEnum.EJECUTIVO);
	}
	
	
	
	public Plato getPLato() {
		return PLato;
	}
	public void setPLato(Plato pLato) {
		PLato = pLato;
	}
	public Bebida getBebida() {
		return bebida;
	}
	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}
	public Postre getPostre() {
		return postre;
	}
	public void setPostre(Postre postre) {
		this.postre = postre;
	}
	
	
	
}
