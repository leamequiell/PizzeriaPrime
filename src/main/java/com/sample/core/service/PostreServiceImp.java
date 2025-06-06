package com.sample.core.service;

import java.util.List;

import com.sample.core.dao.PostreDao;
import com.sample.core.dao.PostreDaoImp;
import com.sample.core.domain.Postre;

public class PostreServiceImp implements PostreService{

	private PostreDao postreDao = new PostreDaoImp();
	
	public List<Postre> listarPostre() throws Exception {
		return postreDao.list();
	}
	
	public Postre consultarPostre(int id) throws Exception {
		return postreDao.findById(id);
	}
	public void crearPostre(String titulo, String descripcion, int precio) throws Exception {
		postreDao.save(titulo, descripcion, precio);
		
	}
	public void delete(int id) throws Exception {
		postreDao.delete(id);
		
	}
	
}
