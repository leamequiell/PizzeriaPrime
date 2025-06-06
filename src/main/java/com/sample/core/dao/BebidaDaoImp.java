package com.sample.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.Bebida;

import com.sample.core.exceptions.ErrorException;

public class BebidaDaoImp implements BebidaDao {

	private static final String queryConsultarBebida = "SELECT id, Precio, Descripcion FROM Bebida where id=?";

	private static final String queryAddBebida= "INSERT INTO bebida ( titulo, descripcion, precio) VALUES (?,?,?)";

	private static final String queryDeleteBebida = "DELETE FROM bebida WHERE id=?";

	private static final String queryList = "SELECT id, titulo, descripcion, precio FROM bebida";

	
	private Conexion conexion = Conexion.getInstance();

	public Bebida findById(int id) throws Exception {
		 ResultSet rs = null;
		 PreparedStatement st = null;
		 try{
			st = conexion.dameConnection().prepareStatement(queryConsultarBebida);
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				return new Bebida(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getInt(4));
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

	public List<Bebida> list() throws Exception {

		PreparedStatement st= null;
		ResultSet rs = null;
		List<Bebida> bebidas = new ArrayList<Bebida>();

		try {
			st = conexion.dameConnection().prepareStatement(queryList);
			rs = st.executeQuery();
			
			while (rs.next()) {
				bebidas.add(new Bebida(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}
			
		} catch (Exception e) {
			System.out.println(e.getCause());
		}finally {
			st.close();
			rs.close();
		}
		
		return bebidas;
	}

	public void save(String titulo, String descripcion, int precioEntero) throws ErrorException {

		 ResultSet rs = null;
		 PreparedStatement st = null;
		 try{
			st = conexion.dameConnection().prepareStatement(queryAddBebida);
			st.setString(1, titulo);
			st.setString(2, descripcion);
			st.setInt(1, precioEntero);
			rs = st.executeQuery();
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
	}

	public void delete(int id) throws Exception {
		 ResultSet rs = null;
		 PreparedStatement st = null;
		 try{
			st = conexion.dameConnection().prepareStatement(queryDeleteBebida);
			st.setInt(1, id);
			rs = st.executeQuery();
			if (!rs.next()) {
				throw new Error("No se encontro el registro");
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
	}

}
