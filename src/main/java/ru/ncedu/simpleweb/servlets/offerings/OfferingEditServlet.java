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


@WebServlet(name = "offeringsEdit", urlPatterns = {"/offerings/edit"})
public class OfferingEditServlet extends HttpServlet {


    private static final String PRODUCTS_ATTR = "products";
    private static final String OFFERING_VIEW_MODEL_ATTR = "offering_view_model";
    private static final String OFFICES_ATTR = "offices";

    private static final String PRODUCT_ID_GET_PARAM = "product_id";
    private static final String OFFICE_ID_GET_PARAM = "office_id";

    private static final String ERROR_ATTR = "error";

    private static final String PRODUCT_ID_PUT_PARAM = "product_id";
    private static final String OFFICE_ID_PUT_PARAM = "office_id";
    private static final String OFFERING_PRICE_PUT_PARAM = "offering_price";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            long productId = Long.parseLong(req.getParameter(PRODUCT_ID_GET_PARAM));
            long officeId = Long.parseLong(req.getParameter(OFFICE_ID_GET_PARAM));

            Offering offering = OfferingsRepository.getInstance().get(new OfferingId(officeId, productId));

            Product product = ProductsRepository.getInstance().get(offering.getProductId());
            Office office = OfficesRepository.getInstance().get(offering.getOfficeId());

            OfferingViewModel offeringViewModel = new OfferingViewModel(offering, product, office);

            req.setAttribute(OFFERING_VIEW_MODEL_ATTR, offeringViewModel);

            req.getRequestDispatcher(Views.OFFERINGS_EDIT).forward(req, res);
        } catch (Exception e) {
            req.setAttribute(ERROR_ATTR, true);
            req.getRequestDispatcher(Views.OFFERINGS_EDIT).forward(req, res);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        String productIdStr = req.getParameter(PRODUCT_ID_PUT_PARAM);
        String officesIdStr = req.getParameter(OFFICE_ID_PUT_PARAM);
        String offeringPriceStr = req.getParameter(OFFERING_PRICE_PUT_PARAM);


        System.out.println(productIdStr);
        System.out.println(officesIdStr);
        System.out.println(offeringPriceStr);
        if (!isValid(productIdStr, officesIdStr, offeringPriceStr)) {
            req.setAttribute(ERROR_ATTR, true);
            req.getRequestDispatcher(Views.OFFERINGS_EDIT).forward(req, res);
            return;
        }
        try {
            long officeId = Long.parseLong(officesIdStr);
            long productId = Long.parseLong(productIdStr);
            double offeringPrice = Double.parseDouble(offeringPriceStr);

            Offering offering = OfferingsRepository.getInstance().get(new OfferingId(officeId, productId));
            offering.setOfferingPrice(offeringPrice);

            OfferingsRepository.getInstance().update(offering);

            res.sendRedirect(req.getContextPath() + "/offerings");
        } catch (Exception e) {
            req.setAttribute(ERROR_ATTR, true);
            req.getRequestDispatcher(Views.OFFERINGS_EDIT).forward(req, res);
        }

    }

    private boolean isValid(String productIdStr, String officeIdStr, String offeringPriceStr) {
        return productIdStr != null && !productIdStr.isEmpty() &&
                officeIdStr != null && !officeIdStr.isEmpty() &&
                offeringPriceStr != null && !offeringPriceStr.isEmpty();
    }
}
