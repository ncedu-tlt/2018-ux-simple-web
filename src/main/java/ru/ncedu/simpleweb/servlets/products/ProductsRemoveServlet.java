package ru.ncedu.simpleweb.servlets.products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONObject;
import ru.ncedu.simpleweb.consts.Views;
import ru.ncedu.simpleweb.repositories.ProductsRepository;

@WebServlet(name = "productsRemove", urlPatterns = {"/products/remove"})

public class ProductsRemoveServlet extends HttpServlet {

    private static final String PRODUCT_ID_PARAM = "productId";
    private static final String ERROR_ATTR = "error";


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productIdStr = request.getParameter(PRODUCT_ID_PARAM);

        if(productIdStr == null || productIdStr.isEmpty()) {
            request.setAttribute(ERROR_ATTR, true);
            request.getRequestDispatcher(Views.PRODUCTS).forward(request, response);
            return;
        }
        long productId = Long.parseLong(request.getParameter(PRODUCT_ID_PARAM));
        boolean success = ProductsRepository.getInstance().remove(productId);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            JSONObject jsonEnt = new JSONObject();
            if (success) {
                jsonEnt.put("serverInfo", "success");
                jsonEnt.put("productId", productId);
            } else {
                jsonEnt.put("serverInfo", "failServlet");
                jsonEnt.put("productId", productId);
            }
            out.print(jsonEnt.toString());
        }

    }
}
