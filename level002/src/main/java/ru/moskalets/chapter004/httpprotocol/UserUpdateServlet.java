package ru.moskalets.chapter004.httpprotocol;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Класс позволяет редактировать данные пользователей.
 */
@WebServlet(value = "/update", loadOnStartup = 0)
public class UserUpdateServlet extends HttpServlet {
    /**
     * validateService.
     */
    private final Validate validateService = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = this.validateService.findById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("user", user);
        req.setAttribute("roles", this.validateService.getAllRoles());
        req.getRequestDispatcher("WEB-INF/views/UserUpdateView.jsp").forward(req, resp);
    }

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        if (req.getParameter("namecity") != null) {
            this.validateService.addCity(new City(req.getParameter("namecity")));
        } else {
            this.validateService.update(new User(Integer.parseInt(req.getParameter("id")), req.getParameter("login"), req.getParameter("password"),
                    req.getParameter("role"), req.getParameter("country"), req.getParameter("city")));
            HttpSession session = req.getSession();
            if (session != null) {
                User user = (User) session.getAttribute("user");
                if (user.getRole().equals("User")) {
                    session.setAttribute("user", this.validateService.findById(Integer.parseInt(req.getParameter("id"))));
                }
            }
        }
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}