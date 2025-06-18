package com.sample.core.service;

import java.util.List;
import com.sample.core.dao.PedidoDao;
import com.sample.core.dao.PedidoDaoImp;
import com.sample.core.dao.PedidoPDao;
import com.sample.core.dao.PedidoPDaolmp;
import com.sample.core.domain.Pedido;
import com.sample.core.enums.PedidoEnum;



public class PedidoServiceImp implements PedidoService {

	private PedidoPDao pedidoDao = new PedidoPDaolmp();

	@Override
    public List<Pedido> listarPedidos() throws Exception {	
        return pedidoDao.list();
    }
	
	public Pedido findByIdAndState(int id, PedidoEnum pedidoEnum) throws Exception {

		return null;
	}

	public void save(Pedido pedido) throws Exception {
		
	}
	
	@Override
    public void actualizarEstado(int idPedido, String estado) throws Exception {
        if (!estado.equalsIgnoreCase("entregado") && !estado.equalsIgnoreCase("proceso")) {
            throw new IllegalArgumentException("Estado no válido");
        }

        PedidoPDao.actualizarEstado(idPedido, estado.toLowerCase());
    }

}
