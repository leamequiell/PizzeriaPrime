package com.sample.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sample.core.dao.config.Conexion;
import com.sample.core.domain.Mesa;
import com.sample.core.enums.EstadoMesa;

public class MesaDaoImp implements MesaDao {

private Conexion conexion = Conexion.getInstance();
	
	private static final String queryList = "SELECT id, numero, estado FROM mesa";
	
	private static final String queryConsultarMesaPorNumero = "SELECT id, numero, estado, mozo FROM mesa where numero=?";
	
	private static final String queryUpdateMesaEstado = "UPDATE mesa SET estado = ?, mozo = ? WHERE numero=?";
	


	public List<Mesa> list() throws Exception {
		
		PreparedStatement st =conexion.dameConnection().prepareCall(queryList);
		ResultSet rs = null;
		rs = st.executeQuery();
		List<Mesa> mesas = new ArrayList<Mesa>();
		while (rs.next())
		{
			mesas.add(new Mesa(rs.getInt(1),rs.getInt(2),
					EstadoMesa.obtenerEstado(rs.getString(3))));
		}
		
		return mesas;
	}


	@Override
	public Mesa findByNumber(int number) throws Exception {
		
		PreparedStatement st = conexion.dameConnection().prepareStatement(queryConsultarMesaPorNumero);
		ResultSet rs = null;
		Mesa mesa=null;
		st.setInt(1, number);
		
		rs = st.executeQuery();
		
		if (rs.next()) {	
		 mesa = new Mesa(rs.getInt(1), rs.getInt(2), EstadoMesa.obtenerEstado(rs.getString(3)));
		 mesa.setMozo(rs.getString(4));
		}
		
		st.close();
		rs.close();
		return mesa;
	}


	@Override
	public void save(int numero, String mozo, EstadoMesa estadoMesa) throws Exception {

		PreparedStatement st = conexion.dameConnection().prepareStatement(queryUpdateMesaEstado);
		
		st.setString(1, estadoMesa.getEstado());
		st.setString(2, mozo);
		st.setInt(3, numero);

		int result = st.executeUpdate();	
	
		if (result == 0) {
			throw new Exception("no se pudo actualizar el registro");
		}
		
		st.close();
		
	}


	@Override
	public void changeState(int numero, EstadoMesa estado, String mozo) throws Exception {
	    PreparedStatement st = null;
	    try {
	        st = conexion.dameConnection().prepareStatement(queryUpdateMesaEstado);
	        
	        st.setString(1, estado.getEstado());
	        st.setString(2, mozo);
	        st.setInt(3, numero);
	        
	        int filasActualizadas = st.executeUpdate();
	        
	        if (filasActualizadas == 0) {
				throw new Exception("Error al reservar mesa");
			};
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new Exception("Error al reservar la mesa", e);
	    } finally {
	        if (st != null) st.close();
	    }
	}

	
	
	
}
