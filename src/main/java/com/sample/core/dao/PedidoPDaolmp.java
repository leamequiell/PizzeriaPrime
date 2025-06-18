package com.sample.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sample.core.dao.config.Conexion;
import com.sample.core.enums.PedidoEnum;
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
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void crearPedido(int idPizza, String estado) {
	    String sql = "INSERT INTO pedido (Estado, pizza) VALUES (?, ?)";

	    try (Connection conn = Conexion.getInstance().dameConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, estado);
	        stmt.setInt(2, idPizza);
	        stmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace(); // te muestra el error exacto en consola
	        throw new RuntimeException("Error al crear pedido", e);
	    }
	}


}
