package ru.ncedu.simpleweb.servlets.countries;

import ru.ncedu.simpleweb.models.Country;
import ru.ncedu.simpleweb.repositories.CountriesRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONObject;

@WebServlet(name = "countryRemove", urlPatterns = {"/countries/remove"})
public class CountriesRemoveServlet extends HttpServlet {

    private static final String COUNTRY_ID_ATTR = "id";

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String countryId = req.getParameter(COUNTRY_ID_ATTR);

        res.setContentType("application/json");
        res.setCharacterEncoding("utf-8");

        if (countryId == null || countryId.isEmpty()) {
            try (PrintWriter out = res.getWriter()) {
                JSONObject jsonEnt = new JSONObject();
                jsonEnt.put("isSuccess", false);
                out.print(jsonEnt.toString());
            }
            return;
        }


        long countryIdNumber = Long.parseLong(countryId);
        boolean isDeleted = false;

        Country country = CountriesRepository.getInstance().get(countryIdNumber);

        if (country != null) {
            isDeleted = CountriesRepository.getInstance().removeById(countryIdNumber);
        }

        try (PrintWriter out = res.getWriter()) {
            JSONObject jsonEnt = new JSONObject();
            if (isDeleted) {
                jsonEnt.put("isSuccess", true);
            } else {
                jsonEnt.put("isSuccess", false);
            }
            out.print(jsonEnt.toString());
        }
    }
}
