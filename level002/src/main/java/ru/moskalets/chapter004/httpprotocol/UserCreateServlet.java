package ru.moskalets.chapter004.httpprotocol;

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
    private final ValidateService validateService = ValidateService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("<!DOCTYPE html"
                        + "html lang=\"en\">"
                        + "<head>"
                        + "<meta charset=\"UTF-8\">"
                        + "<title></title>"
                        + "</head>"
                        + "<body>"
                        + "<form action ='" + req.getContextPath() + "/create' method='post'>"
                            + "Name : <input type='text' name='name'/> "
                            + "Login : <input type='text' name='login'/> "
                            + "Email : <input type='text' name='email'/>"
                            + "<input type='submit'>"
                        + "</form>"
                        + "</body>"
                        + "</html>");
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        this.validateService.add(new User(req.getParameter("name"), req.getParameter("login"), req.getParameter("email")));
    }
}