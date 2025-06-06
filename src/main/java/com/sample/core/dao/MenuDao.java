package com.sample.core.dao;

import java.util.List;

import com.sample.core.domain.Menu;
import com.sample.core.enums.TipoEnum;

public interface MenuDao {

	public List<Menu> listarMenu() throws Exception;
	
	public void addMenu(Menu menu) throws Exception;

	public void addMenu2(String titulo, String descripcion,
						int precio, String idPlato,String idPostre,
						String idBebida, TipoEnum tipo) throws Exception;

	
	public Menu findById(int id) throws Exception;
	
	
}
