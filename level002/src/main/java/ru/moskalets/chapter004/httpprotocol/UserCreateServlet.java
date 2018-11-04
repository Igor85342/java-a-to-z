package ru.moskalets.chapter004.httpprotocol;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Класс позволяет добавлять пользователей.
 */
@WebServlet (value = "/create", loadOnStartup = 0)
public class UserCreateServlet extends HttpServlet {
    /**
     * validateService
     */
    private final Validate validateService = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", this.validateService.getAllRoles());
        req.getRequestDispatcher("WEB-INF/views/UserCreateView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        this.validateService.add(new User(req.getParameter("login"), req.getParameter("password"), req.getParameter("role")));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}