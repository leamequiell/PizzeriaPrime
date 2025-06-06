package com.sample.core.domain;

import java.util.ArrayList;
import java.util.List;

import com.sample.core.enums.EstadoMesa;

public class Mesa extends GenericEntity {


	private int numero;
	
	private EstadoMesa estadoMesa;
	
	private String mozo;
	
	private List<Pedible> pedidos = new ArrayList<Pedible>();
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public EstadoMesa getEstadoMesa() {
		return estadoMesa;
	}

	public void setEstadoMesa(EstadoMesa estadoMesa) {
		this.estadoMesa = estadoMesa;
	}

	public List<Pedible> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedible> pedidos) {
		this.pedidos = pedidos;
	}

	public Mesa(int id, int numero, EstadoMesa estadoMesa) {
		super.setId(id);
		this.numero = numero;
		this.estadoMesa = estadoMesa;
	}

	public void agregarPedible(Pedible pedible){
		this.pedidos.add(pedible);
	}

	public String getMozo() {
		return mozo;
	}

	public void setMozo(String mozo) {
		this.mozo = mozo;
	}
	
}
