package com.sample.core.controller.menu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sample.core.service.MenuService;
import com.sample.core.service.MenuServiceImp;

@WebServlet( urlPatterns =  "/menus")
public class MenuController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MenuService menuService = new MenuServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Gson json = new Gson();
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			out.print(json.toJson(menuService.listar()).toString());
			out.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tipoMenu = req.getParameter("tipo");
		//validar el tipo de menu
		//persistir segun el tipo de menu
		
		
	}

	
	
	
	
	
}
