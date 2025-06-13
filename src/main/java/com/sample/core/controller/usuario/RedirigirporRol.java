package com.sample.core.controller.usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.JsonObject;

@WebServlet("/RedirigirporRol")
public class RedirigirporRol extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        JsonObject json = new JsonObject();

        if (session != null && session.getAttribute("CURRENT_ROL") != null) {
            String rol = (String) session.getAttribute("CURRENT_ROL");
            System.out.println("Rol en sesión: " + rol);
            json.addProperty("rol", rol);
            json.addProperty("status", "ok");
        } else {
            System.out.println("No hay sesión o no existe rol en sesión.");
            json.addProperty("status", "error");
            json.addProperty("message", "Sesión no encontrada o rol no disponible.");
        }

        resp.getWriter().write(json.toString()); // 👈 FALTABA ESTO
    }

}
