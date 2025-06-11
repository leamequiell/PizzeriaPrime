package com.sample.core.domain;

import java.util.ArrayList;
import java.util.List;

import com.sample.core.enums.PedidoEnum;

public class Pedido {

	private List<Pedible> pedibles = new ArrayList<Pedible>();
	
	private PedidoEnum estadoPizza;
	
	public List<Pedible> getPedibles() {
		return pedibles;
	}

	public void addPedible(Pedible pedible) {
		this.pedibles.add(pedible);
	}
	
	public void setPedibles(List<Pedible> pedibles) {
		this.pedibles = pedibles;
	}
	
	public int getTotal() {
		return 0;
	}
	
	public String getTicket() {
		return null;
	}

	
}
