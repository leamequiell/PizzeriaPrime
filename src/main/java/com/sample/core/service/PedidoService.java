package com.sample.core.service;


import com.sample.core.domain.Pedido;
import com.sample.core.enums.PedidoEnum;

public interface PedidoService {

	public Pedido findByIdAndState(int id, PedidoEnum pedidoEnum) throws Exception;
	
	public void save(Pedido pedido) throws Exception;
	
}
