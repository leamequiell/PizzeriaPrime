package com.sample.core.dao;

import java.util.List;
import com.sample.core.domain.Pedido;
import com.sample.core.enums.PedidoEnum;

public interface PedidoDao {
	
	public List<Pedido> list() throws Exception;
    void save(Pedido pedido) throws Exception;
    void actualizarEstado(int idPedido, PedidoEnum nuevoEstado) throws Exception;
    
}
