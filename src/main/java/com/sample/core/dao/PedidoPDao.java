package com.sample.core.dao;

public interface PedidoPDao {

    static void actualizarEstado(int idPedido, String estado) throws Exception {
		// TODO Auto-generated method stub
		
	}

    void crearPedido(int idProducto, String estado) throws Exception;
}
