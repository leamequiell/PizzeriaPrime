package com.sample.core.service;

import java.util.List;

import com.sample.core.domain.Bebida;

public interface BebidaDao {

	
	public List<Bebida> listarBebida() throws Exception;
	
	
	public Bebida consultarBebida(int id) throws Exception;
	
	
	public void persistirBebida(String titulo, String  descripcion, int precio  ) throws Exception;
	
	
	
	
}
