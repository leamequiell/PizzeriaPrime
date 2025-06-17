package com.sample.core.service;

import java.util.List;

import com.sample.core.domain.Pedido;
import com.sample.core.enums.PedidoEnum;

public interface PedidoService {

	public List<Pedido> listarPedidos() throws Exception;

	public Pedido findByIdAndState(int id, PedidoEnum pedidoEnum) throws Exception;
	
	public void save(Pedido pedido) throws Exception;
	
}
	