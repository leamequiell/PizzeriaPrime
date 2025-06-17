package com.sample.core.service;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> 1a365fc9906dfe7b96dbf54251af780befbb444f
import com.sample.core.domain.Pedido;
import com.sample.core.enums.PedidoEnum;

public interface PedidoService {

	public List<Pedido> listarPedidos() throws Exception;

	public Pedido findByIdAndState(int id, PedidoEnum pedidoEnum) throws Exception;

	public void save(Pedido pedido) throws Exception;

	void actualizarEstado(int idPedido, String estado) throws Exception;

}
	