package com.sample.core.controller.pedidoP;

import com.sample.core.domain.Pedido;
import com.sample.core.service.PedidoService;
import com.sample.core.service.PedidoServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/listarPedidos")
public class PedidoListController extends HttpServlet {

    private PedidoService pedidoService = new PedidoServiceImp();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Pedido> pedidos = pedidoService.listarPedidos();
            req.setAttribute("pedidos", pedidos);
            req.getRequestDispatcher("/WEB-INF/views/pedidos/listarPedidos.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(500, "Error al obtener la lista de pedidos");
        }
    }
}
