package ru.ncedu.simpleweb.servlets.offerings;

import org.json.JSONObject;
import ru.ncedu.simpleweb.consts.Views;
import ru.ncedu.simpleweb.models.OfferingId;
import ru.ncedu.simpleweb.repositories.OfferingsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "offeringsRemove", urlPatterns = {"/offerings/remove"})
public class OfferingsRemoveServlet extends HttpServlet {

    private static final String PRODUCT_ID_PARAM = "product_id";
    private static final String OFFICE_ID_PARAM = "office_id";

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String productIdStr = req.getParameter(PRODUCT_ID_PARAM);
        String officeIdStr = req.getParameter(OFFICE_ID_PARAM);

        res.setContentType("application/json");
        res.setCharacterEncoding("utf-8");

        if (!isValid(productIdStr, officeIdStr)) {
            try (PrintWriter out = res.getWriter()) {
                JSONObject jsonEnt = new JSONObject();
                jsonEnt.put("isSuccess", false);
                out.print(jsonEnt.toString());
            }
            return;
        }

        try{
            long productId = Long.parseLong(productIdStr);
            long officeId = Long.parseLong(officeIdStr);
            boolean success = OfferingsRepository.getInstance().removeById(new OfferingId(officeId,productId));
            try (PrintWriter out = res.getWriter()) {
                JSONObject jsonEnt = new JSONObject();
                jsonEnt.put("isSuccess", !success);
                out.print(jsonEnt.toString());
            }
        }catch (Exception e){
            try (PrintWriter out = res.getWriter()) {
                JSONObject jsonEnt = new JSONObject();
                jsonEnt.put("isSuccess", false);
                out.print(jsonEnt.toString());
            }
            return;
        }

    }

    private boolean isValid(String productIdStr, String officeIdStr) {
        return productIdStr != null && !productIdStr.isEmpty() &&
                officeIdStr != null && !officeIdStr.isEmpty();
    }
}