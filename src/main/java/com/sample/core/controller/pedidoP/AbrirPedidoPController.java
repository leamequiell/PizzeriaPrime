package com.sample.core.controller.pedidoP;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.core.domain.Pedido;
import com.sample.core.domain.Pizza;
import com.sample.core.domain.Plato;
import com.sample.core.service.PizzaService;
import com.sample.core.service.PizzaServiceImpl;

@WebServlet(urlPatterns = "/abirPedidoP")
public class AbrirPedidoPController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	PizzaService pizzaService = new PizzaServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String tipo = req.getParameter("estadoPizza");
		String idProducto = req.getParameter("idProducto");
		HttpSession misession = req.getSession(true);
		Pedido pedido = (Pedido) misession.getAttribute("pedido");
		try {
			if (tipo.equals("PIZZA")) {
				int id = Integer.parseInt(idProducto);
				Pizza pizza = pizzaService.consultarPizza(id);
				pedido.addPedible(pizza);
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
