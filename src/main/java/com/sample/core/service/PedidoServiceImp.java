package com.sample.core.service;

import java.util.List;
import com.sample.core.dao.PedidoDao;
import com.sample.core.dao.PedidoDaoImp;
import com.sample.core.domain.Pedido;
import com.sample.core.enums.PedidoEnum;

public class PedidoServiceImp implements PedidoService {

	private PedidoDao pedidoDao = new PedidoDaoImp();

	@Override
    public List<Pedido> listarPedidos() throws Exception {
        return pedidoDao.list();
    }
	
	public Pedido findByIdAndState(int id, PedidoEnum pedidoEnum) throws Exception {

		return null;
	}

	public void save(Pedido pedido) throws Exception {
		
	}

}
