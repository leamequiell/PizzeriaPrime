package com.sample.core.service;

import java.util.List;

import com.sample.core.domain.Bebida;


public interface BebidaService {
	
	public List<Bebida> listarBebidas() throws Exception;
	
	public Bebida consultarBebida(int id) throws Exception;
	
	public void crearBebida (String titulo, String precio, String descripcion) throws Exception;
	
	
	
}
