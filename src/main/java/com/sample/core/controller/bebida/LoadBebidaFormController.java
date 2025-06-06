package com.sample.core.controller.bebida;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.core.domain.Bebida;
import com.sample.core.service.BebidaService;
import com.sample.core.service.BebidaServiceImpl;

@WebServlet(urlPatterns="/LoadBebidaForm")


public class LoadBebidaFormController extends HttpServlet {

private BebidaService bebidaService = new BebidaServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	RequestDispatcher ds = this.getServletContext().getRequestDispatcher("/BebidaForm.jsp");
		
	ds.forward(req, resp);
	}
}
