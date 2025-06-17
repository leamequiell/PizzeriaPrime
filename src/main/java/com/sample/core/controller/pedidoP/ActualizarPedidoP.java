package com.sample.core.controller.pedidoP;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import com.sample.core.service.PedidoService;
import com.sample.core.service.PedidoServiceImp;

@WebServlet("/actualizarEstadoPedido")
public class ActualizarPedidoP extends HttpServlet{

    PedidoService pedidoService = new PedidoServiceImp();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idPedidoStr = req.getParameter("idPedido");
        String nuevoEstado = req.getParameter("estado");

        JsonObject json = new JsonObject();

        try {
            int idPedido = Integer.parseInt(idPedidoStr);
            pedidoService.actualizarEstado(idPedido, nuevoEstado);
            json.addProperty("mensaje", "Estado del pedido actualizado a '" + nuevoEstado + "'");
        } catch (Exception e) {
            e.printStackTrace();
            json.addProperty("error", "Error al actualizar el estado del pedido");
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print(json.toString());
    }
}