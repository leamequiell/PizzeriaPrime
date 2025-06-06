package com.sample.core.controller.pedido;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sample.core.domain.Pedible;
import com.sample.core.domain.Pedido;

@WebServlet( urlPatterns =  "/pedidos")
public class consultarPedidosController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession misession= req.getSession(true);	
		
		Pedido pedido =	(Pedido) misession.getAttribute("pedido");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

		if (pedido != null) {	
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			out.print(gson.toJson(pedido));
			out.flush();			
		}
		
	}

}
