package com.sample.core.controller.pizza;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.core.dao.config.Conexion;
import com.sample.core.service.PizzaService;
import com.sample.core.service.PizzaServiceImpl;


@WebServlet( urlPatterns = "/LeerDatosPizza")
public class LeerDatosPizza extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PizzaService pizzaService = new PizzaServiceImpl();
	
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
	
		try {
			
			req.setAttribute("pizzas", pizzaService.listarPizzas());
			req.getRequestDispatcher("/pizza/pizzaPage.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }


}
