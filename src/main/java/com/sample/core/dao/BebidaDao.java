package com.sample.core.dao;

import java.util.List;

import com.sample.core.domain.Bebida;

public interface BebidaDao {

	public Bebida findById(int id) throws Exception;
	
	public List<Bebida> list() throws Exception;

	public void save(String titulo, String descripcion, int precioEntero) throws Exception;

	public void delete(int id) throws Exception;

}
