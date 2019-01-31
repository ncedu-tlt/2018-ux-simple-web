package ru.ncedu.simpleweb.servlets.offerings;


import ru.ncedu.simpleweb.consts.Views;
import ru.ncedu.simpleweb.models.*;
import ru.ncedu.simpleweb.repositories.OfferingsRepository;
import ru.ncedu.simpleweb.repositories.OfficesRepository;
import ru.ncedu.simpleweb.repositories.ProductsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "offerings", urlPatterns = {"/offerings"})
public class OfferingsServlet extends HttpServlet {

    private final String OFFERINGS_ATTR = "offerings";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Offering> offeringsRepository = OfferingsRepository.getInstance().get();
        List<OfferingViewModel> offerings = new ArrayList<>();

        for (Offering offering : offeringsRepository) {
            Product product = ProductsRepository.getInstance().get(offering.getProductId());
            Office office = OfficesRepository.getInstance().get(offering.getOfficeId());
            OfferingViewModel offeringViewModel = new OfferingViewModel(offering, product, office);
            offerings.add(offeringViewModel);
        }

        req.setAttribute(OFFERINGS_ATTR, offerings);
        req.getRequestDispatcher(Views.OFFERINGS).forward(req, res);
    }
}
