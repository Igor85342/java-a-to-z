package ru.moskalets.hibernate.section001.task001;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(value = "/item", loadOnStartup = 0)
public class ItemServlet extends HttpServlet {
    public final ValidateService validateService = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        Gson gson = new Gson();
        String jsonString = gson.toJson(this.validateService.getAllItems());
        writer.append(jsonString);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.validateService.addItem(new Item(req.getParameter("description"), new Timestamp(System.currentTimeMillis()), Boolean.valueOf(req.getParameter("done")) ));
    }
}