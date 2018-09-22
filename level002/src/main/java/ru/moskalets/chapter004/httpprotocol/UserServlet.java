package ru.moskalets.chapter004.httpprotocol;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Класс выводит список пользователей системы.
 */
@WebServlet(value = "/user", loadOnStartup = 0)
public class UserServlet extends HttpServlet {

    /**
     * validateService
     */
    private final ValidateService validateService = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        if (this.validateService.findAll().isEmpty()) {
                writer.append("Users not found.");
        } else {
            for (User user : this.validateService.findAll().values()) {
                writer.append("<!DOCTYPE html"
                        + "html lang=\"en\">"
                        + "<head>"
                        + "<meta charset=\"UTF-8\">"
                        + "<title></title>"
                        + "</head>"
                        + "<body>"
                        + "<table border='1'>"
                        + "<tr>"
                            + "<td>"
                                + user.printUserInfo()
                            + "</td>"
                            + "<td> "
                                + "<form action ='" + req.getContextPath() + "/update' method='post'>"
                                + "<input type='submit' name='button' value='Update'>"
                                + "<input type='hidden' name='id' value='" + user.getId() + "'"
                            + "</td>"
                        + "</tr>"
                        + "<tr>"
                            + "<td>"
                            + "</td>"
                            + "<td>"
                                + "<form action ='" + req.getContextPath() + "/update' method='post'>"
                                + "<input type='submit' name='button' value='Delete'>"
                            + "</td>"
                        + "</tr>"
                        + "</form>"
                        + "</table>"
                        + "</body>"
                        + "</html>"
                );
                writer.flush();
            }
        }
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}