package com.sample.core.domain;

public class Usuario extends GenericEntity {

	private String usuario;
	private String password;
	private String rol;

	public Usuario(int id, String usuario, String password) {
		super.setId(id);
		this.usuario = usuario;
		this.password = password;
	}

	public Usuario(int id, String usuario, String password, String rol) {
		super.setId(id);
		this.usuario = usuario;
		this.password = password;
		this.rol = rol;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
