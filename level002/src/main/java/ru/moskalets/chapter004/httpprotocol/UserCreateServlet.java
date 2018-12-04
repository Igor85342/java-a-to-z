package ru.moskalets.chapter004.httpprotocol;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder jsonString = new StringBuilder(mapper.writeValueAsString(this.validateService.getAllCities()));
        writer.append(jsonString);
        writer.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", this.validateService.getAllRoles());
        req.getRequestDispatcher("WEB-INF/views/UserCreateView.jsp").forward(req, resp);

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        if (req.getParameter("login") != null) {
            this.validateService.add(new User(req.getParameter("login"), req.getParameter("password"), req.getParameter("role"), req.getParameter("country"), req.getParameter("city")));
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
        }
        if (req.getParameter("namecity") != null) {
            this.validateService.addCity(new City(req.getParameter("namecity")));
        }
    }
}