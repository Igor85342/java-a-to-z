package ru.moskalets.chapter004.httpprotocol;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Класс выводит список пользователей системы.
 */
@WebServlet(value = "/", loadOnStartup = 0)
public class UserServlet extends HttpServlet {

    /**
     * validateService
     */
    private final Validate validateService = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("users", validateService.findAll().values());
            req.getRequestDispatcher("WEB-INF/views/UsersView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}