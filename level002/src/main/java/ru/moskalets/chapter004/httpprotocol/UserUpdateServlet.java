package ru.moskalets.chapter004.httpprotocol;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Класс позволяет редактировать данные пользователей.
 */
@WebServlet(value = "/update", loadOnStartup = 0)
public class UserUpdateServlet extends HttpServlet {
    /**
     * validateService.
     */
    private final ValidateService validateService = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        req.setAttribute("user", user);
        req.getRequestDispatcher("WEB-INF/views/UserUpdateView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        this.validateService.update(new User(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), req.getParameter("login"), req.getParameter("email")));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}