package ru.ncedu.simpleweb.servlets.countries;

import ru.ncedu.simpleweb.consts.Views;
import ru.ncedu.simpleweb.repositories.CountriesRepository;
import ru.ncedu.simpleweb.models.Country;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="countriesAdd", urlPatterns = {"/countries/add"})
public class CountriesAddServlet extends HttpServlet {

    private static final String NAME_PARAM = "name";
    private static final String DESCRIPTION_PARAM = "description";

    private static final String ERROR_ATTR = "error";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        req.getRequestDispatcher(Views.COUNTRIES_ADD).forward(req, res);
    }
}
