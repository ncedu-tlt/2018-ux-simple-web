package ru.ncedu.simpleweb.servlets.countries;

import ru.ncedu.simpleweb.consts.Views;

import ru.ncedu.simpleweb.models.Country;
import ru.ncedu.simpleweb.repositories.CountriesRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "countries", urlPatterns = {"/countries"})
public class CountriesServlet extends HttpServlet {

    private static final String COUNTRIES_ATTR = "countries";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        List<Country> countries = CountriesRepository.getInstance().get();

        req.setAttribute(COUNTRIES_ATTR, countries);
        req.getRequestDispatcher(Views.COUNTRIES).forward(req, res);
    }
}
