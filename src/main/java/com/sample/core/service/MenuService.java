package com.sample.core.service;

import java.util.List;

import com.sample.core.domain.Menu;
import com.sample.core.enums.TipoEnum;

public interface MenuService {

	public List<Menu> listar() throws Exception;
	
	public void addMenu (Menu menu) throws Exception;
	
	public void addMenu (String titulo, String descripcion,
			int precio, String idPlato,String idPostre,
			String idBebida, TipoEnum tipo) throws Exception;

	
	public Menu findById(int id ) throws Exception;
}
