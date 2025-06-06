package com.sample.core.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.Bebida;
import com.sample.core.exceptions.ErrorException;

public class BebidaDaoImp implements BebidaDao {
	
private Conexion conexion = Conexion.getInstance();
	
	private static final String queryList = "SELECT id, Precio, Descripcion FROM Bebida";
	
	private static final String queryConsultarBebida = "SELECT id, precio, descripcion, titulo FROM Plato where idbebida=?";


	public List<Bebida> listarBebida() throws Exception {
		 ResultSet rs = null;
		 List<Bebida> Bebidas = null;
		 Bebida producto = null;
		 PreparedStatement st = null;
		 try{
			st = conexion.dameConnection().prepareStatement(queryList);
			rs = st.executeQuery();
			Bebidas = new ArrayList<Bebida>();
			 while (rs.next()) {
				 producto = new Bebida();
				 producto.setId(rs.getInt(1));
				 producto.setPrecio(rs.getInt(2));
				 producto.setDescripcion(rs.getString(3));
				 Bebidas.add(producto);
			}
				
		 }catch (Exception e) {
				throw new ErrorException("Hubo un error al realizar la consulta", e);
		}finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 
		return Bebidas;
	}

	
	public Bebida consultarBebida(int id) throws Exception {
		 ResultSet rs = null;
		 PreparedStatement st = null;
		 try{
			st = conexion.dameConnection().prepareStatement(queryConsultarBebida);
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				//return new Bebida(rs.getInt(1), rs.getsrt(2),rs.getString(3));
				
			}

		 }catch (Exception e) {
				throw new ErrorException("Hubo un error al realizar la consulta", e);
		}finally {
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}

	public void persistirBebida(String titulo, String descripcion, int precio) throws Exception {
		
		 Statement st =null;
		 ResultSet rs = null;

		 try{
			st = conexion.dameConnection().createStatement();
		    st.getConnection().setAutoCommit(false);
			st.executeUpdate("INSERT INTO Bebida(titulo,descripcion,precio) "
					+ "VALUES('"+titulo+"','"+descripcion+"',"+precio+")");
		    st.getConnection().commit();
		 }catch (Exception e) {
			try {
				st.getConnection().rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			cerrarStatement(st);
		}
		
	}
	
	private void cerrarStatement(Statement st) {
		try {
			st.close ();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
