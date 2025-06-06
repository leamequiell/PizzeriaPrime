package com.sample.core.service;

import java.util.List;

import com.sample.core.dao.BebidaDao;
import com.sample.core.dao.BebidaDaoImp;
import com.sample.core.domain.Bebida;

public class BebidaServiceImpl  implements BebidaService{
	
	private BebidaDao bebidaDao = new BebidaDaoImp();
	
	
	public List<Bebida> listarBebidas() throws Exception {
		return bebidaDao.list();
	}

	public Bebida consultarBebida(int id) throws Exception {
		return bebidaDao.findById(id);
	}

	public void crearBebida(String titulo, String precio, String descripcion) throws Exception {

		int precioEntero =  Integer.parseInt(precio);
		
		bebidaDao.save(titulo, descripcion, precioEntero);
		
	}


}
