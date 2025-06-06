package com.sample.core.controller.pedido;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sample.core.domain.Menu;
import com.sample.core.domain.Pedido;
import com.sample.core.enums.TipoEnum;
import com.sample.core.service.MenuService;
import com.sample.core.service.MenuServiceImp;
import com.sample.core.service.PedidoService;
import com.sample.core.service.PedidoServiceImp;

@WebServlet( urlPatterns =  "/abrirPedido")
public class PedidoSession extends HttpServlet{

	
	
	MenuService menuService = new MenuServiceImp();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession misession= req.getSession(true);	
		//si no existe un pedido en session se crea uno, si existe es por que esta agregando pedibles
	    Pedido pedido =	(Pedido) misession.getAttribute("pedido");
	    if (pedido != null) {
			String idProducto = req.getParameter("idProducto");
			String tipo = req.getParameter("tipo");
			if (tipo.equals(TipoEnum.DELDIA) || tipo.equals(TipoEnum.DELDIA) || tipo.equals(TipoEnum.ESTUDIANTIL) || tipo.equals(TipoEnum.EJECUTIVO)) {
				int idProdInt = Integer.parseInt(idProducto);
			 try {
				Menu menu = menuService.findById(idProdInt);
				pedido.addPedible(menu);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}			
			}
		}else {
			String idMesa = "1";
			//String idmesa = req.getParameter("idMesa");
			int IdMesaInt  = Integer.parseInt(idMesa);
			Pedido pedidoNuevo = new Pedido();
			pedidoNuevo.setIdMesa(IdMesaInt);
			misession.setAttribute("pedido", pedidoNuevo);
			JsonObject json = new JsonObject();
			json.addProperty("mensaje", "abrio un pedido");
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			out.print(json.toString());
			out.flush();
		}
		
		
		
	}

	
	
	
	
}
