package ru.ncedu.simpleweb.servlets.offerings;


import ru.ncedu.simpleweb.consts.Views;
import ru.ncedu.simpleweb.models.Offering;
import ru.ncedu.simpleweb.models.OfferingId;
import ru.ncedu.simpleweb.repositories.OfferingsRepository;
import ru.ncedu.simpleweb.repositories.OfficesRepository;
import ru.ncedu.simpleweb.repositories.ProductsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "offeringsAdd", urlPatterns = {"/offerings/add"})
public class OfferingsAddServlet extends HttpServlet {

    private static final String PRODUCT_ID_PARAM = "product_id";
    private static final String OFFICE_ID_PARAM = "office_id";
    private static final String OFFERING_PRICE_PARAM = "offering_price";

    private static final String ERROR_ATTR = "error";
    private static final String ERROR_SAVE_ATTR = "saveError";
    private static final String OFFICES_ATTR = "offices";
    private static final String PRODUCTS_ATTR = "products";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute(OFFICES_ATTR, OfficesRepository.getInstance().get());
        req.setAttribute(PRODUCTS_ATTR, ProductsRepository.getInstance().get());
        req.getRequestDispatcher(Views.OFFERINGS_ADD).forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String productIdStr = req.getParameter(PRODUCT_ID_PARAM);
        String officeIdStr = req.getParameter(OFFICE_ID_PARAM);
        String offeringPriceStr = req.getParameter(OFFERING_PRICE_PARAM);


        if (!isValid(productIdStr, officeIdStr, offeringPriceStr)) {
            req.setAttribute(OFFICES_ATTR, OfficesRepository.getInstance().get());
            req.setAttribute(PRODUCTS_ATTR, ProductsRepository.getInstance().get());
            req.setAttribute(ERROR_ATTR, true);
            req.getRequestDispatcher(Views.OFFERINGS_ADD).forward(req, res);
            return;
        }

        try {
            long productId = Long.parseLong(productIdStr);
            long officeId = Long.parseLong(officeIdStr);
            double offeringPrice = Double.parseDouble(offeringPriceStr);

            if (OfferingsRepository.getInstance().get(new OfferingId(officeId, productId)) != null) {
                req.setAttribute(OFFICES_ATTR, OfficesRepository.getInstance().get());
                req.setAttribute(PRODUCTS_ATTR, ProductsRepository.getInstance().get());
                req.setAttribute(ERROR_SAVE_ATTR, true);
                req.getRequestDispatcher(Views.OFFERINGS_ADD).forward(req, res);
            } else {
                Offering offering = new Offering();
                offering.setProductId(productId);
                offering.setOfficeId(officeId);
                offering.setOfferingPrice(offeringPrice);

                OfferingsRepository.getInstance().add(offering);

                res.sendRedirect(req.getContextPath() + "/offerings");
            }
            } catch (Exception err) {
            req.setAttribute(OFFICES_ATTR, OfficesRepository.getInstance().get());
            req.setAttribute(PRODUCTS_ATTR, ProductsRepository.getInstance().get());
            req.setAttribute(ERROR_ATTR, true);
            req.getRequestDispatcher(Views.OFFERINGS_ADD).forward(req, res);
        }

    }

    private boolean isValid(String productIdStr, String officeIdStr, String offeringPriceStr) {
        return productIdStr != null && !productIdStr.isEmpty() &&
                officeIdStr != null && !officeIdStr.isEmpty() &&
                offeringPriceStr != null && !offeringPriceStr.isEmpty();
    }
}