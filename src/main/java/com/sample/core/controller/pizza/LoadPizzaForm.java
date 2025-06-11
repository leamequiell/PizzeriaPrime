package com.sample.core.controller.pizza;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.core.domain.Pizza;
import com.sample.core.service.PizzaService;
import com.sample.core.service.PizzaServiceImpl;


@WebServlet( urlPatterns =  "/loadPizzaForm")
public class LoadPizzaForm  extends HttpServlet{

	private PizzaService pizzaService = new PizzaServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	RequestDispatcher ds = this.getServletContext().getRequestDispatcher("/pizzaForm.jsp");
		
		try {
			//req.setAttribute("pizzas", pizzaService.listarPizzas());
			String id = req.getParameter("id");
			 
			// System.err.println(id);
			 
			 Pizza pizza =  pizzaService.consultarPizza( Integer.parseInt(id) );
			 
			 req.setAttribute("pizza", pizza);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ds.forward(req, resp);
		
	}
	
}
