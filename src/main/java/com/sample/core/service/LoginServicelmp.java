package com.sample.core.service;

import com.sample.core.dao.LoginDao;
import com.sample.core.dao.LoginDaolmp;

public class LoginServicelmp implements LoginService{

	private LoginDao loginDao = new LoginDaolmp();
	
	
	public void consultarUsuario(String usuario) throws Exception {
		loginDao.existeUsuario(usuario);
	}


	public void consultarUsuarioYpassword(String usuario, String password) throws Exception {
		loginDao.existeUsuarioPassword(usuario, password);
	}





}
