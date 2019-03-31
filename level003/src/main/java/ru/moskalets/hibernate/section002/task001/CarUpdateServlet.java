package ru.moskalets.hibernate.section002.task001;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = "/updatecar", loadOnStartup = 0)
public class CarUpdateServlet extends HttpServlet {
    private final ValidateService validateService = ValidateService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarXML car = this.validateService.getCarXML(Integer.parseInt(req.getParameter("id")));
        System.out.println(car.getId());
        req.setAttribute("car", car);
        req.getRequestDispatcher("WEB-INF/views/CarUpdateView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        CarXML car = this.validateService.getCarXML(Integer.parseInt(req.getParameter("id")));
        System.out.println(car.getId());
        car.setSold(Boolean.parseBoolean(req.getParameter("sold")));
        this.validateService.updateCar(car);
        resp.sendRedirect(String.format("%s/cars", req.getContextPath()));
    }
}