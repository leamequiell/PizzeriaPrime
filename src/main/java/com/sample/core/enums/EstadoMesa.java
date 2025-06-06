package com.sample.core.enums;

public enum EstadoMesa {
	OCUPADO("OCUPADO"),
	LIBRE("LIBRE");

	private String estado;
	
	EstadoMesa(String estado){
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public static EstadoMesa obtenerEstado(String estado){
		return EstadoMesa.valueOf(estado);
	}
	
}
	
