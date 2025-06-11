package com.sample.core.dao;

import java.util.List;

import com.sample.core.domain.Pizza;

public interface PizzaDao {

	
	public List<Pizza> list() throws Exception;
	
	public Pizza findById(int id) throws Exception;
	
	public void delete (int id) throws Exception;
	
	public void save (String titulo, String descripcion, int precio) throws Exception;
	
	
}
