package com.sample.core.controller.bebida;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.core.service.BebidaService;
import com.sample.core.service.BebidaServiceImpl;

@WebServlet( urlPatterns =  "/crearBebida")
public class BebidaController extends HttpServlet {
	

	BebidaService bebidaService = new BebidaServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String titulo=(String)	req.getAttribute("titulo");
	
		
	String precio = req.getParameter("precio");
	String descripcion = req.getParameter("descripcion");
		
	try {
		bebidaService.crearBebida(titulo, precio, descripcion);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/LeerDatosBebidas");
        dispatcher.forward(req, resp);
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
}



