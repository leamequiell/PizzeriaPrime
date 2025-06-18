package com.sample.core.controller.pedidoP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.sample.core.dao.PedidoPDaolmp;
import com.sample.core.enums.PedidoEnum;

@WebServlet("/crearPedidoP")
public class CrearPedidoPController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            String param = request.getParameter("idPizza");
            int pizzaId = Integer.parseInt(param);

            // Guardar en DB
            PedidoPDaolmp pedidoDao = new PedidoPDaolmp();
            pedidoDao.crearPedido(pizzaId, PedidoEnum.SOLICITADO.name()); // ejemplo de estado

            // Agregar a sesión también (opcional)
            HttpSession session = request.getSession();
            List<Integer> pedido = (List<Integer>) session.getAttribute("pedido");

            if (pedido == null) {
                pedido = new ArrayList<>();
                session.setAttribute("pedido", pedido);
            }

            pedido.add(pizzaId);

            response.getWriter().write("{\"success\": true}");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("{\"success\": false}");
        }
    }
}


