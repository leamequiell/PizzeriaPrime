package com.sample.core.dao;

import java.util.List;

import com.sample.core.domain.Mesa;
import com.sample.core.enums.EstadoMesa;

public interface MesaDao {

	public List<Mesa> list() throws Exception;
	
	public Mesa findByNumber(int number) throws Exception;
	
	public void changeState(int id,EstadoMesa estado,String mozo) throws Exception;
	
	public void save (int numero, String mozo, EstadoMesa estadoMesa) throws Exception;
}
