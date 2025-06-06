package com.sample.core.controller.mesa;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sample.core.service.MesaService;
import com.sample.core.service.MesaServiceImp;
@WebServlet("/mesas")
public class MesasController extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MesaService mesaService = new MesaServiceImp();
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			Gson json = new Gson();					
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			out.print(json.toJson(mesaService.list()));
			out.flush();
			
		} catch (Exception e) {


		}
		
		
		
		
		
	}

}
