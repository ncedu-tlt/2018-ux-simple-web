package ru.ncedu.simpleweb.servlets.offices;


import ru.ncedu.simpleweb.consts.Views;
import ru.ncedu.simpleweb.models.City;
import ru.ncedu.simpleweb.models.Office;
import ru.ncedu.simpleweb.models.OfficeViewModel;
import ru.ncedu.simpleweb.repositories.CitiesRepository;
import ru.ncedu.simpleweb.repositories.OfficesRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "officesEdit", urlPatterns = {"/offices/edit"})
public class OfficesEditServlet extends HttpServlet {

    private static final String OFFICE_ATTR = "office";

    private static final String CITES_ATTR = "cites";
    private static final String CITY_ID_ATTR = "cityId";

    private static final String OFFICE_ID_PARAM = "office_id";
    private static final String NAME_PARAM = "name";
    private static final String PHONE_NUMBER_PARAM = "phone_number";

    private static final String CITY_PARAM = "city";

    private static final String ERROR_ATTR = "error";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long officeId = Long.parseLong(req.getParameter(OFFICE_ID_PARAM));
        Office office = OfficesRepository.getInstance().get(officeId);
        City city = CitiesRepository.getInstance().get(office.getCityId());
        OfficeViewModel officeViewModel = new OfficeViewModel(office, city);

        req.setAttribute(OFFICE_ATTR, officeViewModel);
        req.setAttribute(CITES_ATTR, CitiesRepository.getInstance().get());
        req.setAttribute(CITY_ID_ATTR, city.getId());

        req.getRequestDispatcher(Views.OFFICES_EDIT).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter(NAME_PARAM);
        String phoneNumber = req.getParameter(PHONE_NUMBER_PARAM);
        String cityIdStr = req.getParameter(CITY_PARAM);
        long officeId = Long.parseLong(req.getParameter(OFFICE_ID_PARAM));

        if (!isValid(name, phoneNumber, cityIdStr)) {
            req.setAttribute(ERROR_ATTR, true);
            Office office = OfficesRepository.getInstance().get(officeId);
            City city = CitiesRepository.getInstance().get(office.getCityId());
            OfficeViewModel officeViewModel = new OfficeViewModel(office, city);

            req.setAttribute(OFFICE_ATTR, officeViewModel);
            req.setAttribute(CITES_ATTR, CitiesRepository.getInstance().get());
            req.setAttribute(CITY_ID_ATTR, city.getId());

            req.getRequestDispatcher(Views.OFFICES_EDIT).forward(req, resp);
            return;
        }

        long cityId = Long.parseLong(cityIdStr);
        Office office = OfficesRepository.getInstance().get(officeId);
        office.setName(name);
        office.setPhoneNumber(phoneNumber);
        office.setCityId(cityId);

        OfficesRepository.getInstance().update(office);

        resp.sendRedirect(req.getContextPath() + "/offices");
    }

    private boolean isValid(String name, String phoneNumber, String city) {
        if (name == null || phoneNumber == null || city == null) {
            return false;
        } else {
            name = name.trim();
            phoneNumber = phoneNumber.trim();
            city = city.trim();
            return !name.isEmpty() && !city.isEmpty() && !phoneNumber.isEmpty();
        }
    }


}
