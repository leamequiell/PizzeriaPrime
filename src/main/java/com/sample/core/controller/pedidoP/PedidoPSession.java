package com.sample.core.controller.pedidoP;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.sample.core.domain.Pedido;
import com.sample.core.domain.Pizza;
import com.sample.core.service.PizzaService;
import com.sample.core.service.PizzaServiceImpl;

@WebServlet(urlPatterns = "/abrirPedidoP")
public class PedidoPSession extends HttpServlet {

	private static final long serialVersionUID = 1L;

	PizzaService pizzaService = new PizzaServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession misession = req.getSession(true);
		Pedido pedido = (Pedido) misession.getAttribute("pedido");

		if (pedido == null) {
			pedido = new Pedido();
			misession.setAttribute("pedido", pedido);
		}

		String idProducto = req.getParameter("idProducto");
		String tipo = req.getParameter("estadoPizza"); // ejemplo: "PIZZA"

		JsonObject json = new JsonObject();

		try {
			if ("PIZZA".equalsIgnoreCase(tipo) && idProducto != null) {
				int id = Integer.parseInt(idProducto);
				Pizza pizza = pizzaService.consultarPizza(id);
				pedido.addPedible(pizza);
				json.addProperty("mensaje", "Pizza agregada al pedido");
			} else {
				json.addProperty("mensaje", "Pedido abierto sin agregar producto");
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.addProperty("error", "No se pudo agregar el producto");
		}

		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.print(json.toString());
		out.flush();
	}
}
