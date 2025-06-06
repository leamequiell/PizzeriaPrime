package com.sample.core.dao;

public interface FactoryDao {

	public PlatoDao getPlatoDao();
	
	public MenuDao getMenuDao();
	
	public BebidaDao getBebidaDao();

	public PostreDao getPostreDao();
}
