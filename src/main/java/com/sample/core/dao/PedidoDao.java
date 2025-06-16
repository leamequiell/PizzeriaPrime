package com.sample.core.dao;

import com.sample.core.domain.Pedido;
import com.sample.core.enums.PedidoEnum;

public interface PedidoDao {
    void save(Pedido pedido) throws Exception;
    void actualizarEstado(int idPedido, PedidoEnum nuevoEstado) throws Exception;
}
