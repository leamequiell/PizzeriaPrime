package com.sample.core.service;

import java.util.List;

import com.sample.core.domain.Pizza;

public interface PizzaService {

	public List<Pizza> listarPizzas() throws Exception;
	
	public Pizza consultarPizza(int id) throws Exception;
	
	public void crearPizza(String titulo, String descripcion, int precio) throws Exception;

	public void delete(int id) throws Exception;
}
