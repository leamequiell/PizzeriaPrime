package com.sample.core.controller.pedidoP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/crearPedidoP")
public class CrearPedidoPController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            String param = request.getParameter("idProducto");
            int pizzaId = Integer.parseInt(param);

            // Obtener o crear lista de pedido en sesión
            HttpSession session = request.getSession();
            List<Integer> pedido = (List<Integer>) session.getAttribute("pedido");

            if (pedido == null) {
                pedido = new ArrayList<>();
                session.setAttribute("pedido", pedido);
            }

            pedido.add(pizzaId);

            // Devolver respuesta JSON de éxito
            response.getWriter().write("{\"success\": true}");
        } catch (Exception e) {
            // En caso de error
            response.getWriter().write("{\"success\": false}");
        }
    }
}


