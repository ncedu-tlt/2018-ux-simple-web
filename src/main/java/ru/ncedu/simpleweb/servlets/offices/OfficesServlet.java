package ru.ncedu.simpleweb.servlets.offices;

import ru.ncedu.simpleweb.consts.Views;
import ru.ncedu.simpleweb.models.Office;
import ru.ncedu.simpleweb.repositories.OfficesRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "offices", urlPatterns = {"/offices"})
public class OfficesServlet extends HttpServlet {

    private static final String OFFICES_ATTR = "offices";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Office> offices = OfficesRepository.getInstance().get();
        req.setAttribute(OFFICES_ATTR, offices);
        req.getRequestDispatcher(Views.OFFICES).forward(req, resp);
    }

}
