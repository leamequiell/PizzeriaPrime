package com.sample.core.service;

import java.util.List;

import com.sample.core.domain.Postre;

public interface PostreService {

	List<Postre> listarPostre() throws Exception;

	public Postre consultarPostre(int id) throws Exception;

	public void crearPostre(String titulo, String descripcion, int precio) throws Exception;

	public void delete(int id) throws Exception;
	
}
