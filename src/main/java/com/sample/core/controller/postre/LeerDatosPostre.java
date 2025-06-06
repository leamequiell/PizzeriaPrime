package com.sample.core.controller.postre;

	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import java.sql.Statement;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import com.sample.core.dao.config.Conexion;
	import com.sample.core.service.PostreService;
	import com.sample.core.service.PostreServiceImp;


	@WebServlet( urlPatterns = "/LeerDatosPostre")
	public class LeerDatosPostre extends HttpServlet{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		PostreService postreService = new PostreServiceImp();
		
		
		@Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
		
			try {
				
				req.setAttribute("postres", postreService.listarPostre());
				req.getRequestDispatcher("/postre/postrePage.jsp").forward(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    }


	}