package com.sample.core.controller.postre;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.sample.core.service.PlatoService;
import com.sample.core.service.PlatoServiceImpl;
import com.sample.core.service.PostreService;
import com.sample.core.service.PostreServiceImp;

@WebServlet(urlPatterns = "/CrearPostre")
public class CrearPostreController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	PostreService postreservice = new PostreServiceImp();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String titulo = req.getParameter("titulo");
		String descripcion = req.getParameter("descripcion");
		String precioString = req.getParameter("precio");

		int precioInt = 0;

		// Ver datos recibidos del formulario en pantalla de Eclipse

		precioInt = Integer.parseInt(precioString);

		try { //muestra un mensaje cuando se crea un postre
			postreservice.crearPostre(titulo, descripcion, precioInt);
			PrintWriter out = resp.getWriter(); 
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
			JsonObject obj = new JsonObject();
			// resp.setStatus(200);
			obj.addProperty("estatus", "ok");
			obj.addProperty("mensaje", "Se creo exitosamente el registro");
			out.print(obj.toString());
			out.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
