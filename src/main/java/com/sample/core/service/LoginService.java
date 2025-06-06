package com.sample.core.service;

import java.util.List;

import com.sample.core.domain.Usuario;

public interface LoginService {
			
	public void consultarUsuario(String usuario) throws Exception;
	
	public void consultarUsuarioYpassword(String usuario, String  password) throws Exception;

	
	
}
