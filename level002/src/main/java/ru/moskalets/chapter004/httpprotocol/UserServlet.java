package ru.moskalets.chapter004.httpprotocol;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Класс реализует получение данных от клиента и передачу данных клиенту.
 */
@WebServlet(value = "/user", loadOnStartup = 0)
public class UserServlet extends HttpServlet {

    /**
     * validateService
     */
    private final ValidateService validateService = ValidateService.getInstance();

    /**
     * dispatch
     */
    private final Map<String, Consumer<HttpServletRequest>> dispatch = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
            if (this.validateService.findAll().isEmpty()) {
                writer.println("Users not found.");
            } else {
                for (User user : this.validateService.findAll().values()) {
                    writer.println(user.printUserInfo());
                }
            }
        writer.close();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String action = req.getParameter("action");
        this.dispatch.get(action).accept(req);
    }

    /**
     * Добавляет пользователя.
     */
    Consumer<HttpServletRequest> add = req -> this.validateService.add(new User(req.getParameter("name"), req.getParameter("login"), req.getParameter("email")));

    /**
     * Обновляет данные пользователя.
     */
    Consumer<HttpServletRequest> update = req -> this.validateService.update(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), req.getParameter("login"), req.getParameter("email"));

    /**
     * Удаляет пользователя.
     */
    Consumer<HttpServletRequest> delete = req -> this.validateService.delete(Integer.parseInt(req.getParameter("id")));

    /**
     * Добавляет варианты действия в map.
     */
    public void init() {
        this.dispatch.put("add", add);
        this.dispatch.put("update", update);
        this.dispatch.put("delete", delete);
    }
}