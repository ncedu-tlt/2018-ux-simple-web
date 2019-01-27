package ru.ncedu.simpleweb.servlets.cities;

import ru.ncedu.simpleweb.consts.Views;
import ru.ncedu.simpleweb.models.City;
import ru.ncedu.simpleweb.repositories.CitiesRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "cities", urlPatterns = {"/cities"})
public class CitiesServlet extends HttpServlet {

    private static final String CITIES_ATTR = "cities";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<City> cities = CitiesRepository.getInstance().get();
        req.setAttribute(CITIES_ATTR, cities);

        req.getRequestDispatcher(Views.CITIES).forward(req, resp);
    }
}