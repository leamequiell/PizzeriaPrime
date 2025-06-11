package com.sample.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.Pizza;
import com.sample.core.exceptions.ErrorException;

public class PizzaDaoImp implements PizzaDao {

	
	private Conexion conexion = Conexion.getInstance();
	
	private static final String queryList = "SELECT id, precio, descripcion, titulo FROM pizza";
	
	private static final String queryConsultarPizza = "SELECT id, precio, descripcion, titulo FROM pizza where id=?";
	
	private static final String queryAddPizza = "INSERT INTO pizza ( precio, descripcion, titulo) VALUES (?,?,?)";

	private static final String queryDeletePizza = "DELETE from  pizza where id = ?";

	
	public List<Pizza> list() throws Exception {
		 ResultSet rs = null;
		 List<Pizza> pizzas = null;
		 Pizza producto = null;
		 PreparedStatement st = null;
		 try{
			st = conexion.dameConnection().prepareStatement(queryList);
			rs = st.executeQuery();
			pizzas = new ArrayList<Pizza>();
			 while (rs.next()) {
				 producto = new Pizza(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4));
				 pizzas.add(producto);
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
		 
		return pizzas;
	}

	
	public Pizza findById(int id) throws Exception {
		 ResultSet rs = null;
		 PreparedStatement st = null;
		 try{
			st = conexion.dameConnection().prepareStatement(queryConsultarPizza);
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				return new Pizza(rs.getInt(1), rs.getInt(2),rs.getString(3));
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


	public void delete(int id) throws Exception {

		PreparedStatement st = this.conexion.dameConnection().prepareStatement(queryDeletePizza);
		st.setInt(1, id);
		int registros = st.executeUpdate();
		
		if (registros==0) {
			throw new Exception("hubo un error ");
		}		
		st.close();
	}


	public void save(String titulo, String descripcion, int precio) throws Exception {
	
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			
			st = conexion.dameConnection().prepareStatement(queryAddPizza);		
			st.setInt(1, precio);
			st.setString(2, descripcion);
			st.setString(3, titulo);
			int result= st.executeUpdate();
			if (result==0 ) {
				throw new Exception("hubo un error en base");
			}
		} catch (Exception e) {
			System.out.println(e.getCause());
		}finally {
			finalizarConexion(st);
		}
		
	}
	
	
	private void finalizarConexion(PreparedStatement st) {
		try {
			if(st != null)st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
