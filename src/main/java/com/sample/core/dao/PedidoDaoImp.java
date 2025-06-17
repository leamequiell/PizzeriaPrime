package com.sample.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.Pedido;
import com.sample.core.enums.PedidoEnum;

public class PedidoDaoImp implements PedidoDao {

    private Conexion conexion = Conexion.getInstance();

    private static final String queryInsertPedido = "INSERT INTO pedido (estado) VALUES (?)";
    private static final String queryUpdateEstado = "UPDATE pedido SET estado = ? WHERE id = ?";

    @Override
    public void save(Pedido pedido) throws Exception {
        try (Connection conn = conexion.dameConnection();
             PreparedStatement ps = conn.prepareStatement(queryInsertPedido)) {
            ps.setString(1, pedido.getEstadoPizza().name());
            ps.executeUpdate();
        }
    }

    @Override
    public void actualizarEstado(int idPedido, PedidoEnum nuevoEstado) throws Exception {
        try (Connection conn = conexion.dameConnection();
             PreparedStatement ps = conn.prepareStatement(queryUpdateEstado)) {
            ps.setString(1, nuevoEstado.name());
            ps.setInt(2, idPedido);
            ps.executeUpdate();
        }
    }
}
