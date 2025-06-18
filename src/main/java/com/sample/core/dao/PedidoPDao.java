package com.sample.core.dao;

import java.util.List;

import com.sample.core.domain.Pedido;

public interface PedidoPDao {
	
	public List<Pedido> list() throws Exception;
	
    static void actualizarEstado(int idPedido, String estado) throws Exception {
		// TODO Auto-generated method stub
		
	}

    void crearPedido(int idProducto, String estado) throws Exception;
}
