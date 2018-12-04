package ru.moskalets.chapter004.httpprotocol;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

//@WebServlet(value = "/json", loadOnStartup = 0)
public class JsonController extends HttpServlet {
    private final ConcurrentHashMap<Integer, JsonUser> users = new ConcurrentHashMap<Integer, JsonUser>();
    private final AtomicInteger counter = new AtomicInteger(0);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder jsonString = new StringBuilder(mapper.writeValueAsString(this.users.values()));
        writer.append(jsonString);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.users.put(this.counter.incrementAndGet(), new JsonUser(req.getParameter("name"), req.getParameter("surname"), req.getParameter("sex"), req.getParameter("description")));
    }
}