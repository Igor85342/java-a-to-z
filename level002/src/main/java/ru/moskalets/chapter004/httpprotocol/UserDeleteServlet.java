package ru.moskalets.chapter004.httpprotocol;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet (value = "/delete", loadOnStartup = 0)
public class UserDeleteServlet extends HttpServlet {
    private final Validate validateService = ValidateService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        this.validateService.delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}