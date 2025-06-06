package com.sample.core.controller.bebida;


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

import com.sample.core.service.BebidaService;
import com.sample.core.service.BebidaServiceImpl;


@WebServlet("/LeerDatosBebidas")

public class LeerBebidasController extends HttpServlet {

	private BebidaService bebidaService = new BebidaServiceImpl();
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    
    	
    	try {
			request.setAttribute("conjuntoResultados", bebidaService.listarBebidas());
			request.getRequestDispatcher("/bebida/VerBebidas.jsp").forward(request, response);
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
