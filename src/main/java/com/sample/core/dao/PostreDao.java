package com.sample.core.dao;

import java.util.List;

import com.sample.core.domain.Postre;

public interface PostreDao {
	
	public List<Postre> list() throws Exception;
	
	public Postre findById(int id) throws Exception;
	
	public void save(String titulo, String  descripcion, int precio  ) throws Exception;
	
	public void delete (int id) throws Exception;
}
