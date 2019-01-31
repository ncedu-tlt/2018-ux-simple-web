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

@WebServlet(name = "add", urlPatterns = {"/offices/add"})
public class OfficesAddServlet extends HttpServlet {

    private static final String CITY_ATTR = "city";
    private static final String NAME_PARAM = "name";
    private static final String PHONE_NUMBER_PARAM = "phone_number";
    private static final String CITY_PARAM = "city";
    private static final String ERROR_ATR = "error";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Views.OFFICES_ADD).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        String name = req.getParameter(NAME_PARAM);
        String phoneNumber = req.getParameter(PHONE_NUMBER_PARAM);
//        String city = req.getParameter(CITY_PARAM);

//        long cityId = Long.parseLong(city);
        Office office = new Office();
        office.setName(name);
        office.setCityId(1);
        office.setPhoneNumber(phoneNumber);

        OfficesRepository.getInstance().add(office);

        resp.sendRedirect(req.getContextPath() + "/offices");
    }

}
