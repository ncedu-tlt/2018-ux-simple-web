package ru.ncedu.simpleweb.servlets.products;

import ru.ncedu.simpleweb.consts.Views;
import ru.ncedu.simpleweb.models.Category;
import ru.ncedu.simpleweb.models.Product;
import ru.ncedu.simpleweb.repositories.CategoriesRepository;
import ru.ncedu.simpleweb.repositories.ProductsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productsAdd", urlPatterns = {"/products/add"})
public class ProductsAddServlet extends HttpServlet {

    private static final String CATEGORIES_ATTR = "categories";

    private static final String NAME_PARAM = "name";
    private static final String DESCRIPTION_PARAM = "description";
    private static final String CATEGORY_PARAM = "category";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute(CATEGORIES_ATTR, CategoriesRepository.getInstance().get());

        req.getRequestDispatcher(Views.PRODUCTS_ADD).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter(NAME_PARAM);
        String description = req.getParameter(DESCRIPTION_PARAM);
        String categoryIdStr = req.getParameter(CATEGORY_PARAM);

        long categoryId = Long.parseLong(categoryIdStr);
        Product product = new Product();
        product.setName(name);
        product.setCategoryId(categoryId);
        product.setDescription(description);

        ProductsRepository.getInstance().add(product);

        resp.sendRedirect(req.getContextPath() + "/products");
    }

}
