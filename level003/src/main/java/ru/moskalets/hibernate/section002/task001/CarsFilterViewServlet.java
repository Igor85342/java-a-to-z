package ru.moskalets.hibernate.section002.task001;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet(value = "/filtercars", loadOnStartup = 0)
public class CarsFilterViewServlet extends HttpServlet {
    private final ValidateService validateService = ValidateService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("carsFilter", choiceFilter(req));
        req.getRequestDispatcher("WEB-INF/views/FilterCarsView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    public List<CarXML> choiceFilter(HttpServletRequest req) {
        List<CarXML> list = null;
        if (req.getParameter("button").equals("brandbtn")) {
            list = this.validateService.getCarWithBrand(Integer.parseInt(req.getParameter("brand")));
        }
        if (req.getParameter("button").equals("foto")) {
            list = this.validateService.getCarWithImage();
        }
        if (req.getParameter("button").equals("lastday")) {
            list = this.validateService.getCarLastDay();
        }
        return list;
    }
}