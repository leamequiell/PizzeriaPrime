package com.sample.core.controller.pedidoP;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.core.domain.Pedido;
import com.sample.core.service.PedidoService;
import com.sample.core.service.PedidoServiceImp;

@WebServlet(urlPatterns = "/pedidos")
public class LeerPedidos extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    private PedidoService pedidoService = new PedidoServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        	List<Pedido> lista = pedidoService.listarPedidos();
            req.setAttribute("pedidos", pedidoService.listarPedidos());
            req.getRequestDispatcher("/home/home.jsp").forward(req, resp);
            System.out.println("Pedidos encontrados: " + (lista != null ? lista.size() : "null"));
            req.setAttribute("pedidos", lista);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al listar pedidos");
        }
    }
}
