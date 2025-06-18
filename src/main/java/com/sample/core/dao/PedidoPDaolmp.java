package com.sample.core.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
	
import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.Pedido;
import com.sample.core.domain.Pizza;
import com.sample.core.dao.config.Conexion;
import com.sample.core.enums.PedidoEnum;
import com.sample.core.exceptions.ErrorException;

public class PedidoPDaolmp implements PedidoPDao {

	private Conexion conexion = Conexion.getInstance();

	private static final String queryActualizarEstado = "UPDATE pedido SET estado = ? WHERE id = ?";

	private static final String queryListPedidos = "SELECT id, estado, pizza FROM pedido WHERE id = ?";
	
	
	@Override
	public List<Pedido> list() throws Exception {
	    List<Pedido> pedidos = new ArrayList<>();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    String sql = "SELECT id, estado FROM pedido";

	    try {
	        stmt = conexion.dameConnection().prepareStatement(sql);
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            Pedido pedido = new Pedido();
	            pedido.setId(rs.getInt("id"));
	            pedido.setEstadoPizza(PedidoEnum.valueOf(rs.getString("estado")));
	            // No agregamos nada a pedibles, queda vacío
	            pedidos.add(pedido);
	        }

	    } catch (SQLException e) {
	        throw new ErrorException("Error al listar pedidos", e);
	    } finally {
	        if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
	        if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
	    }

	    return pedidos;
	}
	
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
		System.out.println("utilizando pedidoP");
	}

}
