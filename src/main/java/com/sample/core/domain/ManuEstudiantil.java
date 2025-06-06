package com.sample.core.domain;

import com.sample.core.enums.TipoEnum;

public class ManuEstudiantil extends Menu {

	private Plato plato;
	
	private Bebida bebida;

	public ManuEstudiantil(int id,  String titulo , int precio,  Plato plato, Bebida bebida) {
		super.setId(id);
		super.setTitulo(titulo);
		super.setPrecio(precio);
		this.plato = plato;
		this.bebida = bebida;
		super.setTipo(TipoEnum.ESTUDIANTIL);
		
	}

	public ManuEstudiantil(String titulo , int precio,  Plato plato, Bebida bebida) {
		super.setTitulo(titulo);
		super.setPrecio(precio);
		this.plato = plato;
		this.bebida = bebida;
		super.setTipo(TipoEnum.ESTUDIANTIL);
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public Bebida getBebida() {
		return bebida;
	}

	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}
	
	
	
	
}
