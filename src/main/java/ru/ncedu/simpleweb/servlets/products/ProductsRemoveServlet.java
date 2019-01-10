package ru.ncedu.simpleweb.servlets.products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONObject;
import ru.ncedu.simpleweb.repositories.ProductsRepository;

@WebServlet(name = "productsRemove", urlPatterns = {"/products/remove"})
public class ProductsRemoveServlet extends HttpServlet {

    private static final String PRODUCT_ID_PARAM = "productId";

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productIdStr = request.getParameter(PRODUCT_ID_PARAM);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        if(productIdStr == null || productIdStr.isEmpty()) {
            try (PrintWriter out = response.getWriter()) {
                JSONObject jsonEnt = new JSONObject();
                jsonEnt.put("serverInfo", "fail");
                out.print(jsonEnt.toString());
            }
            return;
        }

        long productId = Long.parseLong(request.getParameter(PRODUCT_ID_PARAM));
        boolean success = ProductsRepository.getInstance().remove(productId);
        try (PrintWriter out = response.getWriter()) {
            JSONObject jsonEnt = new JSONObject();
            if (success) {
                jsonEnt.put("serverInfo", "success");
            } else {
                jsonEnt.put("serverInfo", "fail");
            }
            out.print(jsonEnt.toString());
        }
    }

}
