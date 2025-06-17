package com.sample.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.Pedido;
import com.sample.core.enums.PedidoEnum;
import com.sample.core.exceptions.ErrorException;


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
    private static final String queryList = "SELECT id, estado FROM pedido";

    @Override
    public List<Pedido> list() throws Exception {
        ResultSet rs = null;
        List<Pedido> pedidos = new ArrayList<>();
        PreparedStatement st = null;

        try {
            st = conexion.dameConnection().prepareStatement(queryList);
            rs = st.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setEstadoPizza(PedidoEnum.valueOf(rs.getString("estado")));
                pedidos.add(pedido);
            }

        } catch (Exception e) {
            throw new ErrorException("Hubo un error al listar los pedidos", e);
        } finally {
            try {
                if (st != null) st.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return pedidos;
    }

}
