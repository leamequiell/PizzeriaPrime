package com.sample.core.controller.postre;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.core.domain.Postre;
import com.sample.core.service.PostreService;
import com.sample.core.service.PostreServiceImp;


@WebServlet( urlPatterns =  "/loadPostreForm")
public class LoadPostreForm extends HttpServlet{

	private PostreService postreService = new PostreServiceImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher ds = this.getServletContext().getRequestDispatcher("/postreForm.jsp");

		try {
			// req.setAttribute("platos", platoService.listarPlatos());
			String id = req.getParameter("id");

			// System.err.println(id);

			Postre postre = postreService.consultarPostre(Integer.parseInt(id));

			req.setAttribute("postre", postre);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ds.forward(req, resp);

	}

}
