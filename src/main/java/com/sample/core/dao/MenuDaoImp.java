package com.sample.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.Menu;
import com.sample.core.domain.Plato;
import com.sample.core.enums.TipoEnum;
import com.sample.core.exceptions.ErrorException;

public class MenuDaoImp implements MenuDao {

	private FactoryDao factoryDao = new FactoryDaoImp();
	
	private static final String queryList = "SELECT id, Precio, Descripcion, idPlato,idBebida,idPostre, tipo FROM menu";

	private static final String queryAddMenu= "INSERT INTO menu ( titulo, descripcion, precio, idplato, idpostre, idbebida, tipo) VALUES (?,?,?,?,?,?,?)";
	
	private static final String queryGetOne = "SELECT id, titulo, precio, descripcion, idPlato, idPostre, idBebida, tipo FROM menu where id = ?";

	private Conexion conexion = Conexion.getInstance();

	public List<Menu> listarMenu() throws Exception {

		 ResultSet rs = null;
		 List<Menu> menus = null;
		 Menu unMenu = null;
		 PreparedStatement st = null;
		 try{
			st = conexion.dameConnection().prepareStatement(queryList);
			rs = st.executeQuery();
			menus = new ArrayList<Menu>();
			 while (rs.next()) {
				 unMenu = new Menu();
				 unMenu.setId(rs.getInt(1));
				 unMenu.setPrecio(rs.getInt(1));
				 unMenu.setDescripcion(rs.getString(3));
				 menus.add(unMenu);
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
		 
		return menus;
	}

	public void addMenu(Menu menu) throws Exception {

		
		
		
		
		
	}

	public Menu findById(int id) throws Exception {
		PreparedStatement st = null;
		ResultSet rs = null;		
		Menu menu = null;
		try {
			st = conexion.dameConnection().prepareStatement(queryGetOne);
			st.setInt(1, id);
			rs = st.executeQuery();
			
			while (rs.next()) {
				//revisar como agregr los otros menus
				menu = new Menu(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getString(4), TipoEnum.valueOf(rs.getString(8)));
				//rs.getInt(5);
				//rs.getInt(6);
				//rs.getInt(7);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			st.close();
			rs.close();
		}
		return menu;
	}

	@Override
	public void addMenu2(String titulo, String descripcion, int precio, String idPlato, String idPostre, String idBebida,
			TipoEnum tipo) throws Exception {
		 ResultSet rs = null;
		 PreparedStatement st = null;
		 try{
			st = conexion.dameConnection().prepareStatement(queryAddMenu);
			st.setString(1, titulo);
			st.setString(2, descripcion);
			st.setInt(3, precio);
			st.setString(4, idPlato);
			st.setString(5, idPostre);
			st.setString(6, idBebida);
			st.setString(7, tipo.toString());
			int result = st.executeUpdate();
		 }catch (Exception e) {
				throw new ErrorException("Hubo un error al realizar la consulta", e);
		}finally {
			try {
				st.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		
		
		
		
	}

}
