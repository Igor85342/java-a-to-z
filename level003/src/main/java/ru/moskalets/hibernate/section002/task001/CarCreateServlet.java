package ru.moskalets.hibernate.section002.task001;

import com.google.common.io.ByteStreams;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
@MultipartConfig
@WebServlet(value = "/create", loadOnStartup = 0)
public class CarCreateServlet extends HttpServlet {
    private final ValidateService validateService = ValidateService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("categories", this.validateService.getAllCategories());
        req.setAttribute("brands", this.validateService.getAllBrands());
        req.setAttribute("carbodyes", this.validateService.getAllCarbodyes());
        req.setAttribute("motors", this.validateService.getAllMotors());
        req.setAttribute("transmissions", this.validateService.getAllTransmissions());
        req.getRequestDispatcher("WEB-INF/views/CarCreateView.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Part filePart = req.getPart("file");
        InputStream is  = filePart.getInputStream();
        byte[] image = ByteStreams.toByteArray(is);
        String imageBase64 = Base64.encode(image);
        User user = new User();
        this.validateService.addCar(new CarXML(
                new Category(Integer.parseInt(req.getParameter("category"))),
                new Brand(Integer.parseInt(req.getParameter("brand"))),
                new CarbodyXML(Integer.parseInt(req.getParameter("carbody"))),
                new MotorXML(Integer.parseInt(req.getParameter("motor"))),
                new TransmissionXML(Integer.parseInt(req.getParameter("transmission"))),
                imageBase64,
                false,
                user));
        resp.sendRedirect(String.format("%s/cars", req.getContextPath()));
    }
}