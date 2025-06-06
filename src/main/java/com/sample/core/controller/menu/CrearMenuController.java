package com.sample.core.controller.menu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.sample.core.enums.TipoEnum;
import com.sample.core.service.MenuService;
import com.sample.core.service.MenuServiceImp;

@WebServlet( urlPatterns =  "/crearmenu")
public class CrearMenuController extends HttpServlet{

	MenuService menuService= new MenuServiceImp();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String tipoMenu = req.getParameter("tipo");
		String idPLato = req.getParameter("plato");
		String idPostre = req.getParameter("postre");
		String idBebida = req.getParameter("bebida");
		String titulo = req.getParameter("titulo");	
		String descripcion = req.getParameter("descripcion");
		String precio = req.getParameter("precio");
		
		
		try {
			if (tipoMenu.equals(TipoEnum.DELDIA.getTipo())) {
				menuService.addMenu(titulo,descripcion, Integer.parseInt(precio), idPLato, idPostre, idBebida, TipoEnum.DELDIA);				
			}else if (tipoMenu.equals(TipoEnum.ESTUDIANTIL.getTipo())) {
				menuService.addMenu(titulo,descripcion, Integer.parseInt(precio), idPLato, idPostre, idBebida, TipoEnum.ESTUDIANTIL);				
			}else {
				menuService.addMenu(titulo,descripcion, Integer.parseInt(precio), idPLato, idPostre, idBebida, TipoEnum.EJECUTIVO);				
			}
			PrintWriter out = resp.getWriter();

			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			JsonObject obj = new JsonObject();
			   //resp.setStatus(200);
			obj.addProperty("estatus","ok");
			obj.addProperty("mensaje","Se creo exitosamente el registro");
			out.print(obj.toString());
			out.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}
	
	
}
