package com.sample.core.domain;

import java.util.List;

public class Ticket {

	private List<Pedible> vendibles;
	private String empresa;
	private String cuit;
	

	 public Ticket( List<Pedible> vendibles, String empresam, String cuit  ) {
		 this.vendibles = vendibles;
	}

	public List<Pedible> getVendibles() {
		return vendibles;
	}

	public void setVendibles(List<Pedible> vendibles) {
		this.vendibles = vendibles;
	}

	public String getEmpresa() {
		return empresa;
	}



	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	
	public void immprimir() {
		int total = 0;
		
		for (Pedible vendible : vendibles) {
			
			System.out.println(" descripcion " + vendible.dameTitulo()   );
			total = total + vendible.damePrecio();
			
			System.out.println(" $ " + vendible.damePrecio());
			
		}
		
		System.out.println( "el total es "+ total );
		
		
		
	}
	
	
	
	
	
	
}
