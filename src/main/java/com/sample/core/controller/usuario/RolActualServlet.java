package com.sample.core.controller.usuario;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.sample.core.domain.Usuario;
import com.sample.core.service.LoginService;
import com.sample.core.service.LoginServicelmp;

@WebServlet("/rolActual")
public class RolActualServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();
        JsonObject json = new JsonObject();

        if (session != null && session.getAttribute("CURRENT_ROL") != null) {
            String rol = (String) session.getAttribute("CURRENT_ROL");
            json.addProperty("rol", rol);
        } else {
            json.addProperty("rol", "none"); // o podés poner null
        }

        out.print(json.toString());
        out.flush();
    }
}

