package com.sample.core.service;

import java.util.List;

import com.sample.core.dao.MesaDao;
import com.sample.core.dao.MesaDaoImp;
import com.sample.core.domain.Mesa;
import com.sample.core.enums.EstadoMesa;

public class MesaServiceImp implements MesaService{

	private MesaDao mesaDao = new MesaDaoImp();
	
	public List<Mesa> list() throws Exception {
		return mesaDao.list();
	}

	public Mesa findOne(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void changeState(int numero, EstadoMesa estadoMesa, String mozo) throws Exception {
		mesaDao.changeState(numero, estadoMesa, mozo);
	}

	public void save(int numero,String mozo,  EstadoMesa estadoMesa) throws Exception {
		mesaDao.save(numero, mozo, estadoMesa);
	}

	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Mesa findByNumber(int number) throws Exception {

		return mesaDao.findByNumber(number);
	}

}
