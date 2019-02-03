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
import java.util.regex.Pattern;

@WebServlet(name="countriesAdd", urlPatterns = {"/countries/add"})
public class CountriesAddServlet extends HttpServlet {

    private static final String COUNTRIES_LIST_REDIRECT = "/countries";

    private static final String NAME_PARAM = "countryName";
    private static final String PHONE_PARAM = "phoneExtension";
    private static final String FLAG_PARAM = "flag";

    private static final String ERROR_ATTR = "error";

    private static final String COUNTRY_REGEX = "[^0-9]+";
    private static final String PHONE_REGEX = "^\\+\\d+";
    private static final String FLAG_URL_REGEX = "^https?:.+";

    protected boolean isValid(String countryName, String phoneExtension, String flag) {

        boolean isCountry = Pattern.matches(COUNTRY_REGEX, countryName) && !countryName.isEmpty();
        boolean isPhoneNumber = Pattern.matches(PHONE_REGEX, phoneExtension);
        boolean isFlag = Pattern.matches(FLAG_URL_REGEX, flag);

        return isCountry && isPhoneNumber && isFlag;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        req.getRequestDispatcher(Views.COUNTRIES_ADD).forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String countryName = req.getParameter(NAME_PARAM);
        String phoneExtension = req.getParameter(PHONE_PARAM);
        String flag = req.getParameter(FLAG_PARAM);

        if(!isValid(countryName, phoneExtension, flag)){
            req.setAttribute(ERROR_ATTR, true);
            req.getRequestDispatcher(Views.COUNTRIES_ADD).forward(req, res);
            return;
        }

        Country country = new Country();

        country.setName(countryName);
        country.setPhoneExtension(phoneExtension);
        country.setFlag(flag);

        CountriesRepository.getInstance().add(country);

        res.sendRedirect(req.getContextPath() + COUNTRIES_LIST_REDIRECT);

    }
}
