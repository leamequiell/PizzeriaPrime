package com.sample.core.controller.mesa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;

import com.google.gson.Gson;
import com.sample.core.dao.MesaDao;
import com.sample.core.dao.MesaDaoImp;
import com.sample.core.enums.EstadoMesa;
import com.sample.core.service.MesaService;
import com.sample.core.service.MesaServiceImp;

@WebServlet("/reservarMesa")
public class ReservarMesa extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MesaService mesaService = new MesaServiceImp();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		Gson gson = new Gson();

		try {
			int idMesa = Integer.parseInt(request.getParameter("id"));

			mesaService.changeState(idMesa, EstadoMesa.OCUPADO,"prueba");
			response.setStatus(HttpStatus.SC_OK);
			out.print(gson.toJson("Mesa reservada con éxito"));
			
			//	out.print(gson.toJson("No se pudo reservar la mesa (puede que ya esté ocupada)"));
			
		} catch (Exception e) {
			e.printStackTrace();
			out.print(gson.toJson("Error al procesar la reserva"));
		}

		out.flush();
	}
}
