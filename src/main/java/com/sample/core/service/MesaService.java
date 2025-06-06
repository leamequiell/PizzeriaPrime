package com.sample.core.service;

import java.util.List;

import com.sample.core.domain.Mesa;
import com.sample.core.domain.Plato;
import com.sample.core.enums.EstadoMesa;

public interface MesaService {
	
	public List<Mesa> list() throws Exception;

	public Mesa findOne(int id) throws Exception;
	
	public Mesa findByNumber(int number) throws Exception;

	public void changeState(int id, EstadoMesa estadoMesa, String mozo) throws Exception;
	
	public void save(int numero, String mozo,  EstadoMesa estadoMesa) throws Exception;

	public void delete(int id) throws Exception;
}
