package com.sample.core.dao;

public class FactoryDaoImp implements FactoryDao {

	public PlatoDao getPlatoDao() {		
		return new PlatoDaoImp();
	}

	public MenuDao getMenuDao() {
		return new MenuDaoImp();
	}

	public BebidaDao getBebidaDao() {
		return new BebidaDaoImp();
	}

	public PostreDao getPostreDao() {
		return new PostreDaoImp();
	}
	
	
}
