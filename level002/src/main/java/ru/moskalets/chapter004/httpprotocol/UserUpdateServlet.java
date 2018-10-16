package ru.moskalets.chapter004.httpprotocol;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Класс позволяет редактировать данные пользователей и удалять пользователей.
 */
@WebServlet(value = "/update", loadOnStartup = 0)
public class UserUpdateServlet extends HttpServlet {
    /**
     * validateService.
     */
    private final ValidateService validateService = ValidateService.getInstance();
    /**
     * dispath.
     */
    private final Map<String, Consumer<HttpServletRequest>> dispatch = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        if (this.validateService.findAll().isEmpty()) {
            writer.append("Users not found.");
        } else {
            int id = Integer.parseInt(req.getParameter("id"));
            User user = this.validateService.findAll().get(id);
            if (user.getName() != null) {
                writer.append("<!DOCTYPE html"
                        + "html lang=\"en\">"
                        + "<head>"
                        + "<meta charset=\"UTF-8\">"
                        + "<title></title>"
                        + "</head>"
                        + "<body>"
                        + "<table>"
                        + "<tr>"
                            + "<td>"
                                + "<form action ='" + req.getContextPath() + "/update' method='post'>"
                                + "Name : <input type='text' name='name' value='" + user.getName() + "'/> "
                                + "Login : <input type='text' name='login' value='" + user.getLogin() + "'/> "
                                + "Email : <input type='text' name='email' value='" + user.getEmail() + "'/>"
                                + " <input type='submit' name='button' value='Update'>" + ""
                                + "<input type='hidden' name='id' value='" + user.getId() + "'>"
                                + "</form>"
                            + "</td>"
                        + "</tr>"
                        + "</table>"
                        + "</body>"
                        + "</html>");
            }
            writer.flush();
        }
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
            if (req.getParameter("button").equals("Update")) {
                doGet(req, resp);
            }
            String action = req.getParameter("button");
            this.dispatch.get(action).accept(req);
        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
    }
    /**
     * Обновляет данные пользователя.
     */
    Consumer<HttpServletRequest> update = req -> this.validateService.update(new User(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), req.getParameter("login"), req.getParameter("email")));

    /**
     * Удаляет пользователя.
     */
    Consumer<HttpServletRequest> delete = req -> this.validateService.delete(Integer.parseInt(req.getParameter("id")));

    /**
     * Добавляет варианты действия в map.
     */
    public void init() {
        this.dispatch.put("Update", update);
        this.dispatch.put("Delete", delete);
    }
}