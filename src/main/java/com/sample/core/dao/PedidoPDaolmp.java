package com.sample.core.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sample.core.dao.config.Conexion;
import com.sample.core.exceptions.ErrorException;

public class PedidoPDaolmp implements PedidoPDao {

    private Conexion conexion = Conexion.getInstance();

    private static final String queryActualizarEstado = "UPDATE pedido SET estado = ? WHERE id = ?";

    public void actualizarEstado(int idPedido, String estado) throws Exception {
        PreparedStatement stmt = null;

        try {
            stmt = conexion.dameConnection().prepareStatement(queryActualizarEstado);
            stmt.setString(1, estado); 
            stmt.setInt(2, idPedido);
            stmt.executeUpdate();

        } catch (Exception e) {
            throw new ErrorException("Error al actualizar estado del pedido", e);
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

