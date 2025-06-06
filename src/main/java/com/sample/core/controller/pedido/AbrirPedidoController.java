package com.sample.core.controller.pedido;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.core.domain.Menu;
import com.sample.core.domain.Mesa;
import com.sample.core.domain.Pedido;
import com.sample.core.domain.Plato;
import com.sample.core.service.MenuService;
import com.sample.core.service.MenuServiceImp;
import com.sample.core.service.MesaService;
import com.sample.core.service.MesaServiceImp;
import com.sample.core.service.PlatoService;
import com.sample.core.service.PlatoServiceImpl;

@WebServlet( urlPatterns =  "/agregarPedido")
public class AbrirPedidoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	MesaService mesaService = new MesaServiceImp();
	PlatoService platoService = new PlatoServiceImpl();
	MenuService menuService = new MenuServiceImp();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession misession= req.getSession(true);	
		
		Pedido pedido =	(Pedido) misession.getAttribute("pedido");
		String numMesa = req.getParameter("numero");
		 try {
		  if (pedido == null) {
			 int numeroMesa = Integer.parseInt(numMesa);
			 Mesa mesa =this.mesaService.findByNumber(numeroMesa);
			 pedido = new Pedido();
			 pedido.setIdMesa(mesa.getId());
			 
			 misession.setAttribute("pedido", pedido);
		  }
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 String tipo =  req.getParameter("tipo");
		 String idProducto =  req.getParameter("idProducto");
		 HttpSession misession= req.getSession(true);	
		 Pedido pedido = (Pedido) misession.getAttribute("pedido");
		 try {
			 if (tipo.equals("PLATO")) {
				 int id = Integer.parseInt(idProducto);
				 Plato plato = platoService.consultarPLato(id);
				 pedido.addPedible(plato);
			 }else if (tipo.equals("MENU")) {
				 int id = Integer.parseInt(idProducto);
				 Menu menu = this.menuService.findById(id);
				 pedido.addPedible(menu);
			 }
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		
	}
	}

