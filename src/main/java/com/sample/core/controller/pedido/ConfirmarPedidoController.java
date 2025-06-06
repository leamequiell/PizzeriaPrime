package com.sample.core.controller.pedido;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.core.domain.Pedido;
import com.sample.core.service.PedidoService;
import com.sample.core.service.PedidoServiceImp;

@WebServlet( urlPatterns =  "/confirmarPedido")
public class ConfirmarPedidoController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PedidoService pedidoService = new PedidoServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    
		HttpSession misession= req.getSession(true);	
		
		Pedido pedido =	(Pedido) misession.getAttribute("pedido");

		try {
			pedidoService.save(pedido);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
}
