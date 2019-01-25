package ru.moskalets.chapter004.controltask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

//@WebServlet(value = "/like", loadOnStartup = 0)
public class LikeServlet extends HttpServlet {
    private final AtomicInteger counter = new AtomicInteger(0);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("counter", this.counter.get());
        req.getRequestDispatcher("WEB-INF/views/LikeView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        if ((req.getParameter("like")) != null) {
            this.counter.incrementAndGet();
        }
        doGet(req, resp);
    }
}